/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.message.boards.change.tracking.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.change.tracking.test.util.BaseTableReferenceDefinitionTestCase;
import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalService;
import com.liferay.message.boards.service.MBMailingListLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.change.tracking.CTModel;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Cheryl Tang
 */
@RunWith(Arquillian.class)
public class MBMailingListTableReferenceDefinitionTest
	extends BaseTableReferenceDefinitionTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		_mbCategory = _mbCategoryLocalService.addCategory(
			TestPropsValues.getUserId(),
			MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
			MBCategoryTableReferenceDefinitionTest.class.getSimpleName(),
			MBCategoryTableReferenceDefinitionTest.class.getName(),
			ServiceContextTestUtil.getServiceContext(group.getGroupId()));
	}

	@Override
	protected CTModel<?> addCTModel() throws Exception {
		User user = TestPropsValues.getUser();

		return _mbMailingListLocalService.addMailingList(
			user.getUserId(), group.getGroupId(), _mbCategory.getCategoryId(),
			user.getEmailAddress(), null, null, 0, false, null, null, 0,
			user.getEmailAddress(), false, null, 0, false, null, null, false,
			false,
			ServiceContextTestUtil.getServiceContext(group.getGroupId()));
	}

	private MBCategory _mbCategory;

	@Inject
	private MBCategoryLocalService _mbCategoryLocalService;

	@Inject
	private MBMailingListLocalService _mbMailingListLocalService;

}