/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.discount.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marco Leo
 */
public class CommerceDiscountTargetException extends PortalException {

	public CommerceDiscountTargetException() {
	}

	public CommerceDiscountTargetException(String msg) {
		super(msg);
	}

	public CommerceDiscountTargetException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public CommerceDiscountTargetException(Throwable throwable) {
		super(throwable);
	}

}