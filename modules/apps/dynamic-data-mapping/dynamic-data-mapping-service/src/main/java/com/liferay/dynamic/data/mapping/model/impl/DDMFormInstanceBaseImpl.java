/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.dynamic.data.mapping.model.impl;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;

/**
 * The extended model base implementation for the DDMFormInstance service. Represents a row in the &quot;DDMFormInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMFormInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMFormInstanceImpl
 * @see DDMFormInstance
 * @generated
 */
public abstract class DDMFormInstanceBaseImpl
	extends DDMFormInstanceModelImpl implements DDMFormInstance {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddm form instance model instance should use the <code>DDMFormInstance</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DDMFormInstanceLocalServiceUtil.addDDMFormInstance(this);
		}
		else {
			DDMFormInstanceLocalServiceUtil.updateDDMFormInstance(this);
		}
	}

}