/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.jenkins.results.parser;

import org.json.JSONObject;

/**
 * @author Michael Hashimoto
 */
public class PortalTestSuiteUpstreamJob extends PortalAcceptancePullRequestJob {

	protected PortalTestSuiteUpstreamJob(
		BuildProfile buildProfile, String jobName,
		PortalGitWorkingDirectory portalGitWorkingDirectory,
		String testSuiteName, String upstreamBranchName) {

		super(
			buildProfile, jobName, portalGitWorkingDirectory, testSuiteName,
			upstreamBranchName);
	}

	protected PortalTestSuiteUpstreamJob(JSONObject jsonObject) {
		super(jsonObject);
	}

}