/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.bulk.selection;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public interface BulkSelectionFactoryRegistry {

	public <T> BulkSelectionFactory<T> getBulkSelectionFactory(long classNameId)
		throws PortalException;

	public <T> BulkSelectionFactory<T> getBulkSelectionFactory(
		String className);

}