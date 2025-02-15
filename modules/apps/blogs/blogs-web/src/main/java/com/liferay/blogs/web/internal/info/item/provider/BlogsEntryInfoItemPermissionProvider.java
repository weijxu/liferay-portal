/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.blogs.web.internal.info.item.provider;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.info.exception.InfoItemPermissionException;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.InfoItemIdentifier;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemPermissionProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 */
@Component(service = InfoItemPermissionProvider.class)
public class BlogsEntryInfoItemPermissionProvider
	implements InfoItemPermissionProvider<BlogsEntry> {

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, BlogsEntry blogsEntry,
			String actionId)
		throws InfoItemPermissionException {

		return _hasPermission(
			permissionChecker, blogsEntry.getEntryId(), actionId);
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker,
			InfoItemReference infoItemReference, String actionId)
		throws InfoItemPermissionException {

		InfoItemIdentifier infoItemIdentifier =
			infoItemReference.getInfoItemIdentifier();

		if (!(infoItemIdentifier instanceof ClassPKInfoItemIdentifier)) {
			return false;
		}

		ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
			(ClassPKInfoItemIdentifier)
				infoItemReference.getInfoItemIdentifier();

		return _hasPermission(
			permissionChecker, classPKInfoItemIdentifier.getClassPK(),
			actionId);
	}

	private boolean _hasPermission(
			PermissionChecker permissionChecker, long resourcePrimKey,
			String actionId)
		throws InfoItemPermissionException {

		try {
			return _blogsEntryModelResourcePermission.contains(
				permissionChecker, resourcePrimKey, actionId);
		}
		catch (PortalException portalException) {
			throw new InfoItemPermissionException(
				resourcePrimKey, portalException);
		}
	}

	@Reference(target = "(model.class.name=com.liferay.blogs.model.BlogsEntry)")
	private ModelResourcePermission<BlogsEntry>
		_blogsEntryModelResourcePermission;

}