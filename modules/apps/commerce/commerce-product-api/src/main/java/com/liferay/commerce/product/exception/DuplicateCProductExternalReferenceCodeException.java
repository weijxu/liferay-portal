/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.product.exception;

import com.liferay.portal.kernel.exception.DuplicateExternalReferenceCodeException;

/**
 * @author Marco Leo
 */
public class DuplicateCProductExternalReferenceCodeException
	extends DuplicateExternalReferenceCodeException {

	public DuplicateCProductExternalReferenceCodeException() {
	}

	public DuplicateCProductExternalReferenceCodeException(String msg) {
		super(msg);
	}

	public DuplicateCProductExternalReferenceCodeException(
		String msg, Throwable throwable) {

		super(msg, throwable);
	}

	public DuplicateCProductExternalReferenceCodeException(
		Throwable throwable) {

		super(throwable);
	}

}