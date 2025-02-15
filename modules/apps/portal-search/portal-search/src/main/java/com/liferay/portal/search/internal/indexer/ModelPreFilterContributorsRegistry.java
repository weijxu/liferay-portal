/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.search.internal.indexer;

import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;

import java.util.Collection;
import java.util.List;

/**
 * @author André de Oliveira
 */
public interface ModelPreFilterContributorsRegistry {

	public List<ModelPreFilterContributor> filterModelPreFilterContributor(
		String entryClassName, Collection<String> excludes,
		Collection<String> includes, boolean mandatoryOnly);

}