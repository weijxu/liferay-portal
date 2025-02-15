/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.osb.faro.engine.client;

import com.liferay.osb.faro.engine.client.model.Workspace;

/**
 * @author Matthew Kong
 */
public interface WorkspaceEngineClient {

	public Workspace getWorkspace(String weDeployKey) throws Exception;

}