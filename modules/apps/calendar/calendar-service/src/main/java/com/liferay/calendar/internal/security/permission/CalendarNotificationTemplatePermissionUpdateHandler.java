/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.calendar.internal.security.permission;

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.service.CalendarNotificationTemplateLocalService;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.calendar.model.CalendarNotificationTemplate",
	service = PermissionUpdateHandler.class
)
public class CalendarNotificationTemplatePermissionUpdateHandler
	implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		CalendarNotificationTemplate calendarNotificationTemplate =
			_calendarNotificationTemplateLocalService.
				fetchCalendarNotificationTemplate(GetterUtil.getLong(primKey));

		if (calendarNotificationTemplate == null) {
			return;
		}

		calendarNotificationTemplate.setModifiedDate(new Date());

		_calendarNotificationTemplateLocalService.
			updateCalendarNotificationTemplate(calendarNotificationTemplate);
	}

	@Reference
	private CalendarNotificationTemplateLocalService
		_calendarNotificationTemplateLocalService;

}