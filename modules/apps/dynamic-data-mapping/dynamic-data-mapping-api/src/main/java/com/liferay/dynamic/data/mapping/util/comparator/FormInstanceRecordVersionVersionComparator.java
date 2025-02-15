/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.dynamic.data.mapping.util.comparator;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Comparator;

/**
 * @author Marcellus Tavares
 */
public class FormInstanceRecordVersionVersionComparator
	implements Comparator<DDMFormInstanceRecordVersion> {

	public FormInstanceRecordVersionVersionComparator() {
		this(false);
	}

	public FormInstanceRecordVersionVersionComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion1,
		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion2) {

		int value = 0;

		String version1 = ddmFormInstanceRecordVersion1.getVersion();
		String version2 = ddmFormInstanceRecordVersion2.getVersion();

		int[] versionParts1 = StringUtil.split(version1, StringPool.PERIOD, 0);
		int[] versionParts2 = StringUtil.split(version2, StringPool.PERIOD, 0);

		if ((versionParts1.length != 2) && (versionParts2.length != 2)) {
			value = 0;
		}
		else if (versionParts1.length != 2) {
			value = -1;
		}
		else if (versionParts2.length != 2) {
			value = 1;
		}
		else if (versionParts1[0] > versionParts2[0]) {
			value = 1;
		}
		else if (versionParts1[0] < versionParts2[0]) {
			value = -1;
		}
		else if (versionParts1[1] > versionParts2[1]) {
			value = 1;
		}
		else if (versionParts1[1] < versionParts2[1]) {
			value = -1;
		}

		if (_ascending) {
			return value;
		}

		return -value;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}