/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.notification.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Murilo Stodolni
 */
public class NotificationQueueEntrySubjectException extends PortalException {

	public NotificationQueueEntrySubjectException() {
	}

	public NotificationQueueEntrySubjectException(String msg) {
		super(msg);
	}

	public NotificationQueueEntrySubjectException(
		String msg, Throwable throwable) {

		super(msg, throwable);
	}

	public NotificationQueueEntrySubjectException(Throwable throwable) {
		super(throwable);
	}

}