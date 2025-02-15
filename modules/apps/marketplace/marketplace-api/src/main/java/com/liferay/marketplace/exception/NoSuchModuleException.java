/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.marketplace.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Ryan Park
 */
public class NoSuchModuleException extends NoSuchModelException {

	public NoSuchModuleException() {
	}

	public NoSuchModuleException(String msg) {
		super(msg);
	}

	public NoSuchModuleException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchModuleException(Throwable throwable) {
		super(throwable);
	}

}