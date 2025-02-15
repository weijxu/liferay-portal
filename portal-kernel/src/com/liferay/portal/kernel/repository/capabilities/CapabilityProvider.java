/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.repository.capabilities;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adolfo Pérez
 */
@ProviderType
public interface CapabilityProvider {

	public <T extends Capability> T getCapability(Class<T> capabilityClass);

	public <T extends Capability> boolean isCapabilityProvided(
		Class<T> capabilityClass);

}