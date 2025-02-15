/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.bookmarks.util.comparator;

import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class EntryURLComparator extends OrderByComparator<BookmarksEntry> {

	public static final String ORDER_BY_ASC = "BookmarksEntry.url ASC";

	public static final String ORDER_BY_DESC = "BookmarksEntry.url DESC";

	public static final String[] ORDER_BY_FIELDS = {"url"};

	public EntryURLComparator() {
		this(false);
	}

	public EntryURLComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(BookmarksEntry entry1, BookmarksEntry entry2) {
		String url1 = StringUtil.toLowerCase(entry1.getUrl());
		String url2 = StringUtil.toLowerCase(entry2.getUrl());

		int value = url1.compareTo(url2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}