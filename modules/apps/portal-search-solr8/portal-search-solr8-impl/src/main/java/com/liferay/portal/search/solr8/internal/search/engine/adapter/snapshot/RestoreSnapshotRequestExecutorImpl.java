/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.search.solr8.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.engine.adapter.snapshot.RestoreSnapshotRequest;
import com.liferay.portal.search.engine.adapter.snapshot.RestoreSnapshotResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(service = RestoreSnapshotRequestExecutor.class)
public class RestoreSnapshotRequestExecutorImpl
	implements RestoreSnapshotRequestExecutor {

	@Override
	public RestoreSnapshotResponse execute(
		RestoreSnapshotRequest restoreSnapshotRequest) {

		throw new UnsupportedOperationException();
	}

}