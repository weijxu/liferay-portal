/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {ClayModalProvider, useModal} from '@clayui/modal';
import {sub} from 'frontend-js-web';
import React from 'react';

import DangerModal from '../DangerModal';
import {deleteFolder} from './objectDefinitionUtil';

interface ModalDeleteFolderProps {
	folder: ObjectFolder;
	handleOnClose: () => void;
}

export function ModalDeleteFolder({
	folder,
	handleOnClose,
}: ModalDeleteFolderProps) {
	const {observer, onClose} = useModal({
		onClose: () => {
			handleOnClose();
		},
	});

	return (
		<ClayModalProvider>
			<DangerModal
				errorMessage={sub(
					Liferay.Language.get('input-does-not-match-x'),
					`${folder.name}`
				)}
				observer={observer}
				onClose={onClose}
				onDelete={async () => {
					await deleteFolder(folder?.id, folder?.name);

					setTimeout(() => window.location.reload(), 1500);
					onClose();
				}}
				placeholder={Liferay.Language.get('confirm-folder-name')}
				title={Liferay.Language.get('delete-object-folder')}
				token={folder.name}
			>
				<p>
					{Liferay.Language.get(
						'deleting-an-object-folder-will-move-its-object-definitions'
					)}
				</p>

				<p
					dangerouslySetInnerHTML={{
						__html: sub(
							Liferay.Language.get('please-enter-x-to-confirm'),
							`<strong>${folder.name}</strong>`
						),
					}}
				/>
			</DangerModal>
		</ClayModalProvider>
	);
}
