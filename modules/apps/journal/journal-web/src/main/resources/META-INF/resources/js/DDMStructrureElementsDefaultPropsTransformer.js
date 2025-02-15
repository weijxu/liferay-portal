/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {openConfirmModal, openModal} from 'frontend-js-web';

const ACTIONS = {
	deleteDDMStructure(itemData) {
		openConfirmModal({
			message: Liferay.Language.get(
				'are-you-sure-you-want-to-delete-this'
			),
			onConfirm: (isConfimed) =>
				isConfimed &&
				submitForm(document.hrefFm, itemData.deleteDDMStructureURL),
		});
	},

	importAndOverrideDDMStructure(itemData) {
		Liferay.componentReady(
			`${itemData.portletNamespace}importAndOverrideDataDefinitionModal`
		).then((importAndOverrideDataDefinitionModal) => {
			importAndOverrideDataDefinitionModal.open(
				itemData.importAndOverrideDDMStructureURL
			);
		});
	},

	permissionsDDMStructure(itemData) {
		openModal({
			title: Liferay.Language.get('permissions'),
			url: itemData.permissionsDDMStructureURL,
		});
	},
};

export default function propsTransformer({actions, items, ...props}) {
	const updateItem = (item) => {
		const newItem = {
			...item,
			onClick(event) {
				const action = item.data?.action;

				if (action) {
					event.preventDefault();

					ACTIONS[action]?.(item.data);
				}
			},
		};

		if (Array.isArray(item.items)) {
			newItem.items = item.items.map(updateItem);
		}

		return newItem;
	};

	return {
		...props,
		actions: actions?.map(updateItem),
		items: items?.map(updateItem),
	};
}
