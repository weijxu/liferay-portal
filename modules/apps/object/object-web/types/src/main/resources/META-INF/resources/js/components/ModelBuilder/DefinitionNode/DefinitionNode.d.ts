/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

/// <reference types="react" />

import {NodeProps} from 'react-flow-renderer';
import './DefinitionNode.scss';
import {ObjectDefinitionNodeData} from '../types';
export declare function DefinitionNode({
	data: {
		defaultLanguageId,
		editObjectDefinitionURL,
		externalReferenceCode,
		hasObjectDefinitionDeleteResourcePermission,
		hasObjectDefinitionManagePermissionsResourcePermission,
		id,
		isLinkedNode,
		label,
		name,
		nodeSelected,
		objectDefinitionPermissionsURL,
		objectFields,
		status,
		system,
	},
}: NodeProps<ObjectDefinitionNodeData>): JSX.Element;
