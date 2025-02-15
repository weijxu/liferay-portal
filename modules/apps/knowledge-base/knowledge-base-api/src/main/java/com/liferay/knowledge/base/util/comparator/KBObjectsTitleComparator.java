/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.knowledge.base.util.comparator;

import com.liferay.knowledge.base.model.KBArticle;
import com.liferay.knowledge.base.model.KBFolder;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Roberto Díaz
 */
public class KBObjectsTitleComparator<T> extends OrderByComparator<T> {

	public static final String ORDER_BY_ASC = "title ASC";

	public static final String ORDER_BY_DESC = "title DESC";

	public static final String[] ORDER_BY_FIELDS = {"title"};

	public static final String ORDER_BY_MODEL_ASC =
		"modelFolder DESC, title ASC";

	public static final String ORDER_BY_MODEL_DESC =
		"modelFolder DESC, title DESC";

	public KBObjectsTitleComparator() {
		this(false, false);
	}

	public KBObjectsTitleComparator(boolean ascending) {
		this(ascending, false);
	}

	public KBObjectsTitleComparator(boolean ascending, boolean orderByModel) {
		_ascending = ascending;
		_orderByModel = orderByModel;
	}

	@Override
	public int compare(T t1, T t2) {
		int value = 0;

		String title1 = getTitle(t1);
		String title2 = getTitle(t2);

		if (_orderByModel) {
			if ((t1 instanceof KBFolder) && (t2 instanceof KBFolder)) {
				title1.compareToIgnoreCase(title2);
			}
			else if (t1 instanceof KBFolder) {
				value = -1;
			}
			else if (t2 instanceof KBFolder) {
				value = 1;
			}
			else {
				title1.compareToIgnoreCase(title2);
			}
		}
		else {
			value = title1.compareToIgnoreCase(title2);
		}

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_orderByModel) {
			if (_ascending) {
				return ORDER_BY_MODEL_ASC;
			}

			return ORDER_BY_MODEL_DESC;
		}

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

	protected String getTitle(Object object) {
		if (object instanceof KBArticle) {
			KBArticle kbArticle = (KBArticle)object;

			return kbArticle.getTitle();
		}

		KBFolder kbFolder = (KBFolder)object;

		return kbFolder.getName();
	}

	private final boolean _ascending;
	private final boolean _orderByModel;

}