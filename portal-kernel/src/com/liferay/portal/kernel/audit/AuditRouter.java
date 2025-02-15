/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.audit;

/**
 * @author Michael C. Han
 */
public interface AuditRouter {

	public boolean isDeployed();

	public void route(AuditMessage auditMessage) throws AuditException;

}