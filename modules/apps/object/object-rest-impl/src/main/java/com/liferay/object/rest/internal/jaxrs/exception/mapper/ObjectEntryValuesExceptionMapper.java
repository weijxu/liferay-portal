/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.rest.internal.jaxrs.exception.mapper;

import com.liferay.object.exception.ObjectEntryValuesException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author Javier Gamarra
 */
@Provider
public class ObjectEntryValuesExceptionMapper
	extends BaseExceptionMapper<ObjectEntryValuesException> {

	public ObjectEntryValuesExceptionMapper(Language language) {
		_language = language;
	}

	@Override
	protected Problem getProblem(
		ObjectEntryValuesException objectEntryValuesException) {

		String messageKey = objectEntryValuesException.getMessageKey();

		if (messageKey == null) {
			messageKey = objectEntryValuesException.getMessage();
		}

		if (objectEntryValuesException.getArguments() == null) {
			return new Problem(
				Response.Status.BAD_REQUEST,
				_language.get(
					_acceptLanguage.getPreferredLocale(), messageKey));
		}

		return new Problem(
			Response.Status.BAD_REQUEST,
			_language.format(
				_acceptLanguage.getPreferredLocale(), messageKey,
				objectEntryValuesException.getArguments()));
	}

	@Context
	private AcceptLanguage _acceptLanguage;

	private final Language _language;

}