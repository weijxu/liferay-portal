/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.warehouse.web.internal.frontend.data.set.filter;

import com.liferay.commerce.warehouse.web.internal.constants.CommerceInventoryWarehouseFDSNames;
import com.liferay.frontend.data.set.filter.BaseSelectionFDSFilter;
import com.liferay.frontend.data.set.filter.FDSFilter;

import org.osgi.service.component.annotations.Component;

/**
 * @author Crescenzo Rega
 */
@Component(
	property = "frontend.data.set.name=" + CommerceInventoryWarehouseFDSNames.COMMERCE_INVENTORY_WAREHOUSE_QUALIFIER_CHANNELS,
	service = FDSFilter.class
)
public class CommerceInventoryWarehouseChannelSelectionFDSFilter
	extends BaseSelectionFDSFilter {

	@Override
	public String getAPIURL() {
		return "/o/headless-commerce-admin-channel/v1.0/channels?sort=name:asc";
	}

	@Override
	public String getId() {
		return "channelId";
	}

	@Override
	public String getItemKey() {
		return "id";
	}

	@Override
	public String getItemLabel() {
		return "name";
	}

	@Override
	public String getLabel() {
		return "channel";
	}

	@Override
	public boolean isAutocompleteEnabled() {
		return true;
	}

	@Override
	public boolean isMultiple() {
		return true;
	}

}