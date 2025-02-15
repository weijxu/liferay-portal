/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.headless.delivery.internal.jaxrs.exception.mapper;

import com.liferay.journal.exception.DuplicateFolderNameException;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * Converts any {@code DuplicateFolderNameException} to a {@code 409} error.
 *
 * @author Víctor Galán
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Headless.Delivery)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Headless.Delivery.DuplicateStructuredContentFolderNameExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class DuplicateStructuredContentFolderNameExceptionMapper
	extends BaseExceptionMapper<DuplicateFolderNameException> {

	@Override
	protected Problem getProblem(
		DuplicateFolderNameException duplicateFolderNameException) {

		return new Problem(
			Response.Status.CONFLICT,
			"A structured content folder already exists with the name " +
				duplicateFolderNameException.getMessage());
	}

}