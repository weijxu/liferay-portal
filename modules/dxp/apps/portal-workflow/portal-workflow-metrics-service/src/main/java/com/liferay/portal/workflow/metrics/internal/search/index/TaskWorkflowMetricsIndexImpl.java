/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.workflow.metrics.internal.search.index;

import com.liferay.portal.search.index.IndexNameBuilder;
import com.liferay.portal.workflow.metrics.search.index.constants.WorkflowMetricsIndexNameConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(
	property = "workflow.metrics.index.entity.name=task",
	service = WorkflowMetricsIndex.class
)
public class TaskWorkflowMetricsIndexImpl
	extends BaseWorkflowMetricsIndex implements WorkflowMetricsIndex {

	@Override
	public String getIndexName(long companyId) {
		return _indexNameBuilder.getIndexName(companyId) +
			WorkflowMetricsIndexNameConstants.SUFFIX_TASK;
	}

	@Override
	public String getIndexType() {
		return "WorkflowMetricsTaskType";
	}

	@Reference
	private IndexNameBuilder _indexNameBuilder;

}