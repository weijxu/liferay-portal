/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.data.engine.rest.internal.jaxrs.exception.mapper;

import com.liferay.data.engine.rest.resource.exception.DataDefinitionValidationException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Barros
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Data.Engine.REST)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Data.Engine.REST.DataDefinitionMustSetDefaultLocaleAsAvailableLocaleValidationExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class
	DataDefinitionMustSetDefaultLocaleAsAvailableLocaleValidationExceptionMapper
		extends BaseExceptionMapper
			<DataDefinitionValidationException.
				MustSetDefaultLocaleAsAvailableLocale> {

	@Override
	protected Problem getProblem(
		DataDefinitionValidationException.MustSetDefaultLocaleAsAvailableLocale
			mustSetDefaultLocaleAsAvailableLocale) {

		return new Problem(
			_language.getLanguageId(
				mustSetDefaultLocaleAsAvailableLocale.getDefaultLocale()),
			Response.Status.BAD_REQUEST,
			mustSetDefaultLocaleAsAvailableLocale.getMessage(),
			DataDefinitionValidationException.
				MustSetDefaultLocaleAsAvailableLocale.class.getName());
	}

	@Reference
	private Language _language;

}