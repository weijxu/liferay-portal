/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

/// <reference types="react" />

interface ModalImportObjectDefinitionProps {
	importObjectDefinitionURL: string;
	nameMaxLength: string;
	portletNamespace: string;
}
export default function ModalImportObjectDefinition({
	importObjectDefinitionURL,
	nameMaxLength,
	portletNamespace,
}: ModalImportObjectDefinitionProps): JSX.Element | null;
export {};
