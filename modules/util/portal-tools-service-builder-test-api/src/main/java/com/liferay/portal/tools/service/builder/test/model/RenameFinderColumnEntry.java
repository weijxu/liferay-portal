/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.tools.service.builder.test.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RenameFinderColumnEntry service. Represents a row in the &quot;RenameFinderColumnEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RenameFinderColumnEntryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.tools.service.builder.test.model.impl.RenameFinderColumnEntryImpl"
)
@ProviderType
public interface RenameFinderColumnEntry
	extends PersistedModel, RenameFinderColumnEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.tools.service.builder.test.model.impl.RenameFinderColumnEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RenameFinderColumnEntry, Long>
		RENAME_FINDER_COLUMN_ENTRY_ID_ACCESSOR =
			new Accessor<RenameFinderColumnEntry, Long>() {

				@Override
				public Long get(
					RenameFinderColumnEntry renameFinderColumnEntry) {

					return renameFinderColumnEntry.
						getRenameFinderColumnEntryId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<RenameFinderColumnEntry> getTypeClass() {
					return RenameFinderColumnEntry.class;
				}

			};

}