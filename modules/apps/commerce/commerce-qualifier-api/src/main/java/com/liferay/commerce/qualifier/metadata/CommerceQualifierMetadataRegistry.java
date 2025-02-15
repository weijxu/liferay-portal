/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.qualifier.metadata;

import java.util.List;

/**
 * @author Riccardo Alberti
 */
public interface CommerceQualifierMetadataRegistry {

	public CommerceQualifierMetadata getCommerceQualifierMetadata(
		String commerceQualifierMetadataKey);

	public CommerceQualifierMetadata getCommerceQualifierMetadataByClassName(
		String className);

	public List<CommerceQualifierMetadata> getCommerceQualifierMetadatas();

}