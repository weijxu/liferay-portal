/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion;
import com.liferay.portal.workflow.kaleo.service.KaleoDefinitionVersionLocalServiceUtil;

/**
 * The extended model base implementation for the KaleoDefinitionVersion service. Represents a row in the &quot;KaleoDefinitionVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoDefinitionVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoDefinitionVersionImpl
 * @see KaleoDefinitionVersion
 * @generated
 */
public abstract class KaleoDefinitionVersionBaseImpl
	extends KaleoDefinitionVersionModelImpl implements KaleoDefinitionVersion {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo definition version model instance should use the <code>KaleoDefinitionVersion</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			KaleoDefinitionVersionLocalServiceUtil.addKaleoDefinitionVersion(
				this);
		}
		else {
			KaleoDefinitionVersionLocalServiceUtil.updateKaleoDefinitionVersion(
				this);
		}
	}

}