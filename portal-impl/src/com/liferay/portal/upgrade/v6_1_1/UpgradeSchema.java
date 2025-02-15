/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.upgrade.v6_1_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Julio Camarero
 */
public class UpgradeSchema extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQLTemplate("update-6.1.0-6.1.1.sql", false);

		upgrade(new UpgradeMVCCVersion());
	}

}