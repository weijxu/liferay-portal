/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.client.extension.type.internal.factory;

import com.liferay.client.extension.exception.ClientExtensionEntryTypeSettingsException;
import com.liferay.client.extension.model.ClientExtensionEntry;
import com.liferay.client.extension.type.ThemeCSSCET;
import com.liferay.client.extension.type.factory.CETImplFactory;
import com.liferay.client.extension.type.internal.ThemeCSSCETImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import java.util.Properties;

import javax.portlet.PortletRequest;

/**
 * @author Iván Zaera Avellón
 */
public class ThemeCSSCETImplFactoryImpl implements CETImplFactory<ThemeCSSCET> {

	@Override
	public ThemeCSSCET create(ClientExtensionEntry clientExtensionEntry)
		throws PortalException {

		return new ThemeCSSCETImpl(clientExtensionEntry);
	}

	@Override
	public ThemeCSSCET create(PortletRequest portletRequest)
		throws PortalException {

		return new ThemeCSSCETImpl(portletRequest);
	}

	@Override
	public ThemeCSSCET create(
			String baseURL, long companyId, String description,
			String externalReferenceCode, String name, Properties properties,
			String sourceCodeURL, UnicodeProperties unicodeProperties)
		throws PortalException {

		return new ThemeCSSCETImpl(
			baseURL, companyId, description, externalReferenceCode, name,
			properties, sourceCodeURL, unicodeProperties);
	}

	@Override
	public void validate(
			UnicodeProperties newTypeSettingsUnicodeProperties,
			UnicodeProperties oldTypeSettingsUnicodeProperties)
		throws PortalException {

		ThemeCSSCET newThemeCSSCET = new ThemeCSSCETImpl(
			StringPool.BLANK, newTypeSettingsUnicodeProperties);

		String baseURL = newThemeCSSCET.getBaseURL();

		if (!Validator.isBlank(baseURL) && !Validator.isUrl(baseURL, true)) {
			throw new ClientExtensionEntryTypeSettingsException(
				"please-enter-a-valid-base-url");
		}

		String clayURL = newThemeCSSCET.getClayURL();

		if (!Validator.isBlank(clayURL) && !Validator.isUrl(clayURL, true)) {
			throw new ClientExtensionEntryTypeSettingsException(
				"please-enter-a-valid-clay-url");
		}

		String mainURL = newThemeCSSCET.getMainURL();

		if (!Validator.isBlank(mainURL) && !Validator.isUrl(mainURL, true)) {
			throw new ClientExtensionEntryTypeSettingsException(
				"please-enter-a-valid-main-url");
		}
	}

}