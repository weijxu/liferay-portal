/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.util;

import com.liferay.commerce.model.CommerceShippingEngine;

import java.util.Map;

/**
 * @author Andrea Di Giorgi
 */
public interface CommerceShippingEngineRegistry {

	public CommerceShippingEngine getCommerceShippingEngine(String key);

	public Map<String, CommerceShippingEngine> getCommerceShippingEngines();

}