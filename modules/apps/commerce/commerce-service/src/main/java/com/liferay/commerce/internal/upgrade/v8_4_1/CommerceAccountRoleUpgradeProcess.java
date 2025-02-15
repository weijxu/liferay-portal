/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.internal.upgrade.v8_4_1;

import com.liferay.account.constants.AccountActionKeys;
import com.liferay.account.constants.AccountRoleConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrea Sbarra
 */
public class CommerceAccountRoleUpgradeProcess extends UpgradeProcess {

	public CommerceAccountRoleUpgradeProcess(
		CompanyLocalService companyLocalService,
		ResourceActionLocalService resourceActionLocalService,
		ResourcePermissionLocalService resourcePermissionLocalService,
		RoleLocalService roleLocalService) {

		_companyLocalService = companyLocalService;
		_resourceActionLocalService = resourceActionLocalService;
		_resourcePermissionLocalService = resourcePermissionLocalService;
		_roleLocalService = roleLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		List<String> actionIds = new ArrayList<>();

		actionIds.add(AccountActionKeys.MANAGE_ADDRESSES);
		actionIds.add(AccountActionKeys.VIEW_ADDRESSES);

		_resourceActionLocalService.checkResourceActions(
			"com.liferay.commerce.order", actionIds);

		_companyLocalService.forEachCompanyId(
			companyId -> {
				_updateCommerceAccountRoles(
					companyId,
					AccountRoleConstants.
						REQUIRED_ROLE_NAME_ACCOUNT_ADMINISTRATOR,
					"com.liferay.commerce.order", actionIds);
				_updateCommerceAccountRoles(
					companyId, AccountRoleConstants.ROLE_NAME_ACCOUNT_BUYER,
					"com.liferay.commerce.order", actionIds);
				_updateCommerceAccountRoles(
					companyId,
					AccountRoleConstants.ROLE_NAME_ACCOUNT_ORDER_MANAGER,
					"com.liferay.commerce.order", actionIds);
			});
	}

	private void _addResourcePermission(
			long companyId, Role role, String resourceName, String actionId)
		throws PortalException {

		_resourcePermissionLocalService.addResourcePermission(
			companyId, resourceName, ResourceConstants.SCOPE_GROUP_TEMPLATE,
			String.valueOf(GroupConstants.DEFAULT_PARENT_GROUP_ID),
			role.getRoleId(), actionId);
	}

	private void _updateCommerceAccountRoles(
			long companyId, String name, String resourceName,
			List<String> actionIds)
		throws PortalException {

		Role role = _roleLocalService.fetchRole(companyId, name);

		if (role == null) {
			return;
		}

		for (String actionId : actionIds) {
			_addResourcePermission(companyId, role, resourceName, actionId);
		}
	}

	private final CompanyLocalService _companyLocalService;
	private final ResourceActionLocalService _resourceActionLocalService;
	private final ResourcePermissionLocalService
		_resourcePermissionLocalService;
	private final RoleLocalService _roleLocalService;

}