/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Marco Leo
 */
public class NoSuchObjectLayoutRowException extends NoSuchModelException {

	public NoSuchObjectLayoutRowException() {
	}

	public NoSuchObjectLayoutRowException(String msg) {
		super(msg);
	}

	public NoSuchObjectLayoutRowException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchObjectLayoutRowException(Throwable throwable) {
		super(throwable);
	}

}