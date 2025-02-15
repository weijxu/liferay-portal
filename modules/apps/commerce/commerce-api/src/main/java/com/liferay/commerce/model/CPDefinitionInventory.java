/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CPDefinitionInventory service. Represents a row in the &quot;CPDefinitionInventory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alessio Antonio Rendina
 * @see CPDefinitionInventoryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.commerce.model.impl.CPDefinitionInventoryImpl"
)
@ProviderType
public interface CPDefinitionInventory
	extends CPDefinitionInventoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.commerce.model.impl.CPDefinitionInventoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CPDefinitionInventory, Long>
		CP_DEFINITION_INVENTORY_ID_ACCESSOR =
			new Accessor<CPDefinitionInventory, Long>() {

				@Override
				public Long get(CPDefinitionInventory cpDefinitionInventory) {
					return cpDefinitionInventory.getCPDefinitionInventoryId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<CPDefinitionInventory> getTypeClass() {
					return CPDefinitionInventory.class;
				}

			};

	public java.math.BigDecimal[] getAllowedOrderQuantitiesArray();

}