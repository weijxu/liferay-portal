/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.calendar.upgrade.v2_0_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.test.util.CalendarBookingTestUtil;
import com.liferay.calendar.test.util.CalendarTestUtil;
import com.liferay.calendar.test.util.CalendarUpgradeTestUtil;
import com.liferay.calendar.test.util.CheckBookingsSchedulerJobConfigurationTestUtil;
import com.liferay.calendar.test.util.UpgradeDatabaseTestHelper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DataGuard;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.SynchronousMailTestRule;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Adam Brandizzi
 */
@DataGuard(scope = DataGuard.Scope.METHOD)
@RunWith(Arquillian.class)
public class UpgradeSchemaTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), SynchronousMailTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_calendar = CalendarTestUtil.addCalendar(_group);

		_upgradeDatabaseTestHelper =
			CalendarUpgradeTestUtil.getUpgradeDatabaseTestHelper();
		_upgradeProcess = CalendarUpgradeTestUtil.getUpgradeStep(
			_upgradeStepRegistrator,
			"com.liferay.calendar.internal.upgrade.v2_0_0." +
				"SchemaUpgradeProcess");

		CheckBookingsSchedulerJobConfigurationTestUtil.setUp();
	}

	@After
	public void tearDown() throws Exception {
		CheckBookingsSchedulerJobConfigurationTestUtil.tearDown();

		_upgradeDatabaseTestHelper.close();
	}

	@Test
	public void testUpgradeCreatesCalendarBookingRecurringId()
		throws Exception {

		dropColumnRecurringCalendarBookingId();

		assertDoesNotHaveColumn("recurringCalendarBookingId");

		_upgradeProcess.upgrade();

		assertHasColumn("recurringCalendarBookingId");
	}

	@Test
	public void testUpgradeSetsRecurringCalendarBookingId() throws Exception {
		CalendarBooking calendarBooking =
			CalendarBookingTestUtil.addRegularCalendarBooking(_calendar);

		long recurringCalendarBookingId =
			calendarBooking.getRecurringCalendarBookingId();

		dropColumnRecurringCalendarBookingId();

		_upgradeProcess.upgrade();

		assertRecurringCalendarBookingIdValue(
			calendarBooking, recurringCalendarBookingId);
	}

	protected void assertDoesNotHaveColumn(String columnName) throws Exception {
		Assert.assertFalse(
			_upgradeDatabaseTestHelper.hasColumn(
				"CalendarBooking", columnName));
	}

	protected void assertHasColumn(String columnName) throws Exception {
		Assert.assertTrue(
			_upgradeDatabaseTestHelper.hasColumn(
				"CalendarBooking", columnName));
	}

	protected void assertRecurringCalendarBookingIdValue(
			CalendarBooking calendarBooking, long recurringCalendarBookingId)
		throws PortalException {

		EntityCacheUtil.clearCache();

		Assert.assertNotEquals(
			0, calendarBooking.getRecurringCalendarBookingId());

		calendarBooking = _calendarBookingLocalService.getCalendarBooking(
			calendarBooking.getCalendarBookingId());

		Assert.assertEquals(
			recurringCalendarBookingId,
			calendarBooking.getRecurringCalendarBookingId());
	}

	protected void dropColumnRecurringCalendarBookingId() throws Exception {
		_upgradeDatabaseTestHelper.dropColumn(
			"com.liferay.calendar.internal.upgrade.v1_0_0.util." +
				"CalendarBookingTable",
			"CalendarBooking", "recurringCalendarBookingId");
	}

	private Calendar _calendar;

	@Inject
	private CalendarBookingLocalService _calendarBookingLocalService;

	private Group _group;
	private UpgradeDatabaseTestHelper _upgradeDatabaseTestHelper;
	private UpgradeProcess _upgradeProcess;

	@Inject(
		filter = "component.name=com.liferay.calendar.internal.upgrade.registry.CalendarServiceUpgradeStepRegistrator"
	)
	private UpgradeStepRegistrator _upgradeStepRegistrator;

}