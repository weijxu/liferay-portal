/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.client.extension.type.internal;

import com.liferay.client.extension.constants.ClientExtensionEntryConstants;
import com.liferay.client.extension.model.ClientExtensionEntry;
import com.liferay.client.extension.type.IFrameCET;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.UnicodePropertiesBuilder;

import java.util.Properties;
import java.util.Set;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class IFrameCETImpl extends BaseCETImpl implements IFrameCET {

	public IFrameCETImpl(ClientExtensionEntry clientExtensionEntry) {
		super(clientExtensionEntry);
	}

	public IFrameCETImpl(PortletRequest portletRequest) {
		this(
			StringPool.BLANK,
			UnicodePropertiesBuilder.create(
				true
			).put(
				"friendlyURLMapping",
				ParamUtil.getString(portletRequest, "friendlyURLMapping")
			).put(
				"instanceable",
				ParamUtil.getBoolean(portletRequest, "instanceable")
			).put(
				"portletCategoryName",
				ParamUtil.getString(portletRequest, "portletCategoryName")
			).put(
				"url", ParamUtil.getString(portletRequest, "url")
			).build());
	}

	public IFrameCETImpl(
		String baseURL, long companyId, String description,
		String externalReferenceCode, String name, Properties properties,
		String sourceCodeURL, UnicodeProperties typeSettingsUnicodeProperties) {

		super(
			baseURL, companyId, description, externalReferenceCode, name,
			properties, sourceCodeURL, typeSettingsUnicodeProperties);
	}

	public IFrameCETImpl(
		String baseURL, UnicodeProperties typeSettingsUnicodeProperties) {

		super(baseURL, typeSettingsUnicodeProperties);
	}

	@Override
	public String getEditJSP() {
		return "/admin/edit_iframe.jsp";
	}

	@Override
	public String getFriendlyURLMapping() {
		return getString("friendlyURLMapping");
	}

	@Override
	public String getPortletCategoryName() {
		return getString("portletCategoryName");
	}

	@Override
	public String getType() {
		return ClientExtensionEntryConstants.TYPE_IFRAME;
	}

	@Override
	public String getURL() {
		return getString("url");
	}

	@Override
	public boolean hasProperties() {
		return true;
	}

	@Override
	public boolean isInstanceable() {
		return getBoolean("instanceable");
	}

	@Override
	protected boolean isURLCETPropertyName(String name) {
		return _urlCETPropertyNames.contains(name);
	}

	private static final Set<String> _urlCETPropertyNames =
		getURLCETPropertyNames(IFrameCET.class);

}