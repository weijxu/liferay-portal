/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

/// <reference types="react" />

import './ModalMoveObjectDefinition.scss';
interface ModalMoveObjectDefinitionProps {
	foldersList: ObjectFolder[];
	handleOnClose: () => void;
	objectDefinition: ObjectDefinition;
	selectedFolder: Partial<ObjectFolder>;
	setMoveObjectDefinition: (value: ObjectDefinition | null) => void;
}
export declare function ModalMoveObjectDefinition({
	foldersList,
	handleOnClose,
	objectDefinition,
	selectedFolder,
	setMoveObjectDefinition,
}: ModalMoveObjectDefinitionProps): JSX.Element;
export {};
