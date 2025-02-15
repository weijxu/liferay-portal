/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.users.admin.uad.anonymizer.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.service.UserTrackerLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import com.liferay.user.associated.data.anonymizer.UADAnonymizer;
import com.liferay.user.associated.data.test.util.BaseUADAnonymizerTestCase;

import com.liferay.users.admin.uad.test.UserTrackerUADTestHelper;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@RunWith(Arquillian.class)
public class UserTrackerUADAnonymizerTest extends BaseUADAnonymizerTestCase<UserTracker> {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new LiferayIntegrationTestRule();

	@After
	public void tearDown() throws Exception {
		_userTrackerUADTestHelper.cleanUpDependencies(_userTrackers);
	}

	@Override
	protected UserTracker addBaseModel(long userId) throws Exception {
		return addBaseModel(userId, true);
	}

	@Override
	protected UserTracker addBaseModel(long userId, boolean deleteAfterTestRun)
		throws Exception {
		UserTracker userTracker = _userTrackerUADTestHelper.addUserTracker(userId);

		if (deleteAfterTestRun) {
			_userTrackers.add(userTracker);
		}

		return userTracker;
	}

	@Override
	protected void deleteBaseModels(List<UserTracker> baseModels)
		throws Exception {
		_userTrackerUADTestHelper.cleanUpDependencies(baseModels);
	}

	@Override
	protected UADAnonymizer getUADAnonymizer() {
		return _uadAnonymizer;
	}

	@Override
	protected boolean isBaseModelAutoAnonymized(long baseModelPK, User user)
		throws Exception {
		return isBaseModelDeleted(baseModelPK);
	}

	@Override
	protected boolean isBaseModelDeleted(long baseModelPK) {
		if (_userTrackerLocalService.fetchUserTracker(baseModelPK) == null) {
			return true;
		}

		return false;
	}

	@DeleteAfterTestRun
	private final List<UserTracker> _userTrackers = new ArrayList<UserTracker>();
	@Inject
	private UserTrackerLocalService _userTrackerLocalService;
	@Inject
	private UserTrackerUADTestHelper _userTrackerUADTestHelper;
	@Inject(filter = "component.name=*.UserTrackerUADAnonymizer")
	private UADAnonymizer _uadAnonymizer;
}