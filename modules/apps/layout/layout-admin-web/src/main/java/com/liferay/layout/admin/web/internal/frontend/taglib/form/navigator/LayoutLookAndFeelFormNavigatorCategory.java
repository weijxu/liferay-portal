/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.layout.admin.web.internal.frontend.taglib.form.navigator;

import com.liferay.frontend.taglib.form.navigator.FormNavigatorCategory;
import com.liferay.frontend.taglib.form.navigator.constants.FormNavigatorConstants;
import com.liferay.portal.kernel.language.Language;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "form.navigator.category.order:Integer=20",
	service = FormNavigatorCategory.class
)
public class LayoutLookAndFeelFormNavigatorCategory
	implements FormNavigatorCategory {

	@Override
	public String getFormNavigatorId() {
		return FormNavigatorConstants.FORM_NAVIGATOR_ID_LAYOUT_DESIGN;
	}

	@Override
	public String getKey() {
		return FormNavigatorConstants.CATEGORY_KEY_LAYOUT_LOOK_AND_FEEL;
	}

	@Override
	public String getLabel(Locale locale) {
		return _language.get(locale, "look-and-feel");
	}

	@Reference
	private Language _language;

}