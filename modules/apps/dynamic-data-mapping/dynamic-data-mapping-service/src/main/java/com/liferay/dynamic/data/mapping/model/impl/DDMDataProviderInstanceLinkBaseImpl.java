/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.dynamic.data.mapping.model.impl;

import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstanceLink;
import com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLinkLocalServiceUtil;

/**
 * The extended model base implementation for the DDMDataProviderInstanceLink service. Represents a row in the &quot;DDMDataProviderInstanceLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMDataProviderInstanceLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMDataProviderInstanceLinkImpl
 * @see DDMDataProviderInstanceLink
 * @generated
 */
public abstract class DDMDataProviderInstanceLinkBaseImpl
	extends DDMDataProviderInstanceLinkModelImpl
	implements DDMDataProviderInstanceLink {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddm data provider instance link model instance should use the <code>DDMDataProviderInstanceLink</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DDMDataProviderInstanceLinkLocalServiceUtil.
				addDDMDataProviderInstanceLink(this);
		}
		else {
			DDMDataProviderInstanceLinkLocalServiceUtil.
				updateDDMDataProviderInstanceLink(this);
		}
	}

}