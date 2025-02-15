/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.journal.web.internal.frontend.taglib.form.navigator;

import com.liferay.frontend.taglib.form.navigator.FormNavigatorEntry;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = "form.navigator.entry.order:Integer=20",
	service = FormNavigatorEntry.class
)
public class JournalRelatedAssetsFormNavigatorEntry
	extends BaseJournalFormNavigatorEntry {

	@Override
	public String getKey() {
		return "related-assets";
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Override
	protected String getJspPath() {
		return "/article/related_assets.jsp";
	}

	@Reference(target = "(osgi.web.symbolicname=com.liferay.journal.web)")
	private ServletContext _servletContext;

}