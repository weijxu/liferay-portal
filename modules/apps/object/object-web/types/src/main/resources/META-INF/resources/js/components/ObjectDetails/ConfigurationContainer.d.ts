/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

/// <reference types="react" />

interface ConfigurationContainerProps {
	hasUpdateObjectDefinitionPermission: boolean;
	isLinkedNode?: boolean;
	isRootDescendantNode: boolean;
	setValues: (values: Partial<ObjectDefinition>) => void;
	values: Partial<ObjectDefinition>;
}
export declare function ConfigurationContainer({
	hasUpdateObjectDefinitionPermission,
	isLinkedNode,
	isRootDescendantNode,
	setValues,
	values,
}: ConfigurationContainerProps): JSX.Element;
export {};
