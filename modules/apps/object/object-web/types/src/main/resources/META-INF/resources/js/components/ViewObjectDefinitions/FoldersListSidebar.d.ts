/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {SetStateAction} from 'react';
import {ViewObjectDefinitionsModals} from './ViewObjectDefinitions';
interface FoldersListSidebarProps {
	foldersList: ObjectFolder[];
	selectedFolder: ObjectFolder;
	setSelectedFolder: (value: SetStateAction<Partial<ObjectFolder>>) => void;
	setShowModal: (value: SetStateAction<ViewObjectDefinitionsModals>) => void;
}
export default function FoldersListSideBar({
	foldersList,
	selectedFolder,
	setSelectedFolder,
	setShowModal,
}: FoldersListSidebarProps): JSX.Element;
export {};
