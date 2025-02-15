/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.workflow.metrics.rest.internal.resource.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Rafael Praxedes
 */
public class NoSuchInstanceException extends NoSuchModelException {

	public NoSuchInstanceException() {
	}

	public NoSuchInstanceException(String msg) {
		super(msg);
	}

	public NoSuchInstanceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchInstanceException(Throwable throwable) {
		super(throwable);
	}

}