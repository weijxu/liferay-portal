/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.journal.exception;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleTitleException extends PortalException {

	public ArticleTitleException() {
	}

	public ArticleTitleException(String msg) {
		super(msg);
	}

	public ArticleTitleException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ArticleTitleException(Throwable throwable) {
		super(throwable);
	}

	public static class MustNotExceedMaximumLength
		extends ArticleTitleException {

		public MustNotExceedMaximumLength(String title, int titleMaxLength) {
			super(
				StringBundler.concat(
					"Title ", title, " must have fewer than ", titleMaxLength,
					" characters"));
		}

	}

}