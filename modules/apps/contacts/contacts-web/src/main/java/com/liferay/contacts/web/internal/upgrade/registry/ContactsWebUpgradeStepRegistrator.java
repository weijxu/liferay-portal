/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.contacts.web.internal.upgrade.registry;

import com.liferay.contacts.web.internal.upgrade.v1_0_0.UpgradePortletId;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(service = UpgradeStepRegistrator.class)
public class ContactsWebUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.registerInitialization();

		registry.register("0.0.1", "1.0.1", new UpgradePortletId());

		// See LPS-65946

		registry.register("1.0.0", "1.0.1", new UpgradePortletId());
	}

}