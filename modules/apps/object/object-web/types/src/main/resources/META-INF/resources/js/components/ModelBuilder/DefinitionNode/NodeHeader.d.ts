/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

/// <reference types="react" />

import './NodeHeader.scss';
import {DropDownItems} from '../types';
interface NodeHeaderProps {
	dropDownItems: DropDownItems[];
	isLinkedNode: boolean;
	objectDefinitionLabel: string;
	status: {
		code: number;
		label: string;
		label_i18n: string;
	};
	system: boolean;
}
export default function NodeHeader({
	dropDownItems,
	isLinkedNode,
	objectDefinitionLabel,
	status,
	system,
}: NodeHeaderProps): JSX.Element;
export {};
