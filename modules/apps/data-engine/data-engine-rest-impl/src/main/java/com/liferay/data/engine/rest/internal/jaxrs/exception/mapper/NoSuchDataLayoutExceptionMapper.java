/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.data.engine.rest.internal.jaxrs.exception.mapper;

import com.liferay.dynamic.data.mapping.exception.NoSuchStructureLayoutException;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Leonardo Barros
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Data.Engine.REST)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Data.Engine.REST.NoSuchDataLayoutExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class NoSuchDataLayoutExceptionMapper
	extends BaseExceptionMapper<NoSuchStructureLayoutException> {

	@Override
	protected Problem getProblem(
		NoSuchStructureLayoutException noSuchStructureLayoutException) {

		return new Problem(
			Response.Status.NOT_FOUND,
			noSuchStructureLayoutException.getMessage());
	}

}