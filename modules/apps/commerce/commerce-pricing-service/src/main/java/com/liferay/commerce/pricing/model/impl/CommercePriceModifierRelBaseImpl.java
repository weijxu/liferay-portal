/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.pricing.model.impl;

import com.liferay.commerce.pricing.model.CommercePriceModifierRel;
import com.liferay.commerce.pricing.service.CommercePriceModifierRelLocalServiceUtil;

/**
 * The extended model base implementation for the CommercePriceModifierRel service. Represents a row in the &quot;CommercePriceModifierRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceModifierRelImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelImpl
 * @see CommercePriceModifierRel
 * @generated
 */
public abstract class CommercePriceModifierRelBaseImpl
	extends CommercePriceModifierRelModelImpl
	implements CommercePriceModifierRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price modifier rel model instance should use the <code>CommercePriceModifierRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommercePriceModifierRelLocalServiceUtil.
				addCommercePriceModifierRel(this);
		}
		else {
			CommercePriceModifierRelLocalServiceUtil.
				updateCommercePriceModifierRel(this);
		}
	}

}