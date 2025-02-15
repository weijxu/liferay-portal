/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.dao.jdbc;

import java.sql.SQLException;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public interface MappingSqlQuery<T> {

	public List<T> execute(Object... params) throws SQLException;

}