/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.service.permission;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Charles May
 */
public interface UserPermission {

	public void check(
			PermissionChecker permissionChecker, long userId,
			long[] organizationIds, String actionId)
		throws PrincipalException;

	public void check(
			PermissionChecker permissionChecker, long userId, String actionId)
		throws PrincipalException;

	public boolean contains(
		PermissionChecker permissionChecker, long userId,
		long[] organizationIds, String actionId);

	public boolean contains(
		PermissionChecker permissionChecker, long userId, String actionId);

}