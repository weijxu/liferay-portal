/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.shipping.engine.fedex.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.fedex.ws.rate.v22.DropoffType;

import com.liferay.commerce.shipping.engine.fedex.internal.constants.FedExCommerceShippingEngineConstants;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Andrea Di Giorgi
 */
@ExtendedObjectClassDefinition(
	category = "shipping", scope = ExtendedObjectClassDefinition.Scope.GROUP
)
@Meta.OCD(
	id = "com.liferay.commerce.shipping.engine.fedex.internal.configuration.FedExCommerceShippingEngineGroupServiceConfiguration",
	localization = "content/Language",
	name = "commerce-shipping-engine-fedex-group-service-configuration-name"
)
public interface FedExCommerceShippingEngineGroupServiceConfiguration {

	@Meta.AD(
		deflt = FedExCommerceShippingEngineConstants.PACKING_TYPE_BY_DIMENSIONS,
		name = "packing-type", required = false
	)
	public String packingType();

	@Meta.AD(
		deflt = DropoffType._BUSINESS_SERVICE_CENTER, name = "dropoff-type",
		required = false
	)
	public String dropoffType();

	@Meta.AD(name = "account-number", required = false)
	public String accountNumber();

	@Meta.AD(name = "use-residential-rates", required = false)
	public boolean useResidentialRates();

	@Meta.AD(name = "use-discounted-rates", required = false)
	public boolean useDiscountedRates();

	@Meta.AD(name = "key", required = false)
	public String key();

	@Meta.AD(name = "meter-number", required = false)
	public String meterNumber();

	@Meta.AD(name = "password", required = false)
	public String password();

	@Meta.AD(name = "service-types", required = false)
	public String serviceTypes();

	@Meta.AD(name = "url", required = false)
	public String url();

	@Meta.AD(deflt = "150", name = "max-weight-pounds", required = false)
	public int maxWeightPounds();

	@Meta.AD(deflt = "68", name = "max-weight-kilograms", required = false)
	public int maxWeightKilograms();

	@Meta.AD(deflt = "165", name = "max-size-inches", required = false)
	public int maxSizeInches();

	@Meta.AD(deflt = "419", name = "max-size-centimeters", required = false)
	public int maxSizeCentimeters();

}