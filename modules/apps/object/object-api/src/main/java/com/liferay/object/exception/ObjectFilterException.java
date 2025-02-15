/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marco Leo
 */
public class ObjectFilterException extends PortalException {

	public ObjectFilterException() {
	}

	public ObjectFilterException(String msg) {
		super(msg);
	}

	public ObjectFilterException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ObjectFilterException(Throwable throwable) {
		super(throwable);
	}

}