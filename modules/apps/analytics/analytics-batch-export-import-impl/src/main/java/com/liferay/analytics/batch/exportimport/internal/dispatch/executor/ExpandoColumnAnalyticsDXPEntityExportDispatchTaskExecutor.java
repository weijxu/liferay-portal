/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.analytics.batch.exportimport.internal.dispatch.executor;

import com.liferay.dispatch.executor.DispatchTaskExecutor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcos Martins
 */
@Component(
	property = {
		"dispatch.task.executor.name=" + ExpandoColumnAnalyticsDXPEntityExportDispatchTaskExecutor.KEY,
		"dispatch.task.executor.type=" + ExpandoColumnAnalyticsDXPEntityExportDispatchTaskExecutor.KEY
	},
	service = DispatchTaskExecutor.class
)
public class ExpandoColumnAnalyticsDXPEntityExportDispatchTaskExecutor
	extends BaseAnalyticsDXPEntityExportDispatchTaskExecutor {

	public static final String KEY =
		"export-expando-column-analytics-dxp-entities";

	@Override
	public String getName() {
		return KEY;
	}

	@Override
	protected String getBatchEngineExportTaskItemDelegateName() {
		return "expando-column-analytics-dxp-entities";
	}

}