/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.portal.tools.service.builder.test.model.LocalizedEntry;
import com.liferay.portal.tools.service.builder.test.service.LocalizedEntryLocalServiceUtil;

/**
 * The extended model base implementation for the LocalizedEntry service. Represents a row in the &quot;LocalizedEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalizedEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizedEntryImpl
 * @see LocalizedEntry
 * @generated
 */
public abstract class LocalizedEntryBaseImpl
	extends LocalizedEntryModelImpl implements LocalizedEntry {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a localized entry model instance should use the <code>LocalizedEntry</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LocalizedEntryLocalServiceUtil.addLocalizedEntry(this);
		}
		else {
			LocalizedEntryLocalServiceUtil.updateLocalizedEntry(this);
		}
	}

}