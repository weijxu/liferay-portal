/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.bean.portlet.cdi.extension.internal.mvc;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import javax.mvc.security.Encoders;

/**
 * @author Neil Griffin
 */
@ApplicationScoped
public class EncodersProducer {

	@ApplicationScoped
	@Produces
	public Encoders getEncoders() {
		return new EncodersImpl();
	}

}