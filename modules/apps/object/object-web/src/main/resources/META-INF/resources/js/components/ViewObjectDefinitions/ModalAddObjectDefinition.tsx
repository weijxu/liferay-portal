/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayForm from '@clayui/form';
import ClayModal, {ClayModalProvider, useModal} from '@clayui/modal';
import {
	API,
	BetaButton,
	FormError,
	Input,
	REQUIRED_MSG,
	Select,
	openToast,
	useForm,
} from '@liferay/object-js-components-web';
import {sub} from 'frontend-js-web';
import React, {useState} from 'react';

import {defaultLanguageId} from '../../utils/constants';

import './ModalAddObjectDefinition.scss';
import {normalizeName} from './objectDefinitionUtil';

interface ModalAddObjectDefinitionProps {
	apiURL: string;
	handleOnClose: () => void;
	objectFolderExternalReferenceCode?: string;
	onAfterSubmit?: (value: ObjectDefinition) => void;
	reload?: boolean;
	storages: LabelValueObject[];
}

type TInitialValues = {
	label: string;
	name?: string;
	pluralLabel: string;
	storage: LabelValueObject;
};

export function ModalAddObjectDefinition({
	apiURL,
	handleOnClose,
	objectFolderExternalReferenceCode,
	onAfterSubmit,
	reload = true,
	storages,
}: ModalAddObjectDefinitionProps) {
	const [error, setError] = useState<string>('');

	const {observer, onClose} = useModal({
		onClose: () => handleOnClose(),
	});

	const storageSortedByLabel = [...storages].sort(
		(firstStorage, secondStorage) => {
			const firstLabel = firstStorage.label.toLowerCase();
			const secondLabel = secondStorage.label.toLowerCase();

			if (firstLabel < secondLabel) {
				return -1;
			}
			else if (firstLabel > secondLabel) {
				return 1;
			}
			else {
				return 0;
			}
		}
	);

	const initialValues: TInitialValues = {
		label: '',
		name: undefined,
		pluralLabel: '',
		storage: storageSortedByLabel[0],
	};

	const onSubmit = async ({
		label,
		name,
		pluralLabel,
		storage,
	}: TInitialValues) => {
		const objectDefinition: Partial<ObjectDefinition> = {
			label: {
				[defaultLanguageId]: label,
			},
			name: name || normalizeName(label),
			objectFields: [],
			pluralLabel: {
				[defaultLanguageId]: pluralLabel,
			},
			scope: 'company',
		};

		if (
			Liferay.FeatureFlags['LPS-148856'] &&
			objectFolderExternalReferenceCode
		) {
			objectDefinition.objectFolderExternalReferenceCode = objectFolderExternalReferenceCode;
		}

		if (
			Liferay.FeatureFlags['LPS-148856'] &&
			objectFolderExternalReferenceCode
		) {
			objectDefinition.objectFolderExternalReferenceCode = objectFolderExternalReferenceCode;
		}

		if (Liferay.FeatureFlags['LPS-135430']) {
			objectDefinition.storageType = storage.value;
		}
		try {
			const newObjectDefinition = ((await API.save({
				item: objectDefinition,
				method: 'POST',
				returnValue: true,
				url: apiURL,
			})) as unknown) as ObjectDefinition;

			onClose();

			openToast({
				message: sub(
					Liferay.Language.get('x-was-created-successfully'),
					`<strong>${label}</strong>`
				),
				type: 'success',
			});

			if (onAfterSubmit) {
				onAfterSubmit(newObjectDefinition);
			}

			if (reload) {
				setTimeout(() => window.location.reload(), 1000);
			}
		}
		catch (error) {
			setError((error as Error).message);
		}
	};

	const validate = (values: TInitialValues) => {
		const errors: FormError<TInitialValues> = {};

		if (!values.label) {
			errors.label = REQUIRED_MSG;
		}
		if (!(values.name ?? values.label)) {
			errors.name = REQUIRED_MSG;
		}
		if (!values.pluralLabel) {
			errors.pluralLabel = REQUIRED_MSG;
		}

		return errors;
	};

	const {errors, handleChange, handleSubmit, setValues, values} = useForm({
		initialValues,
		onSubmit,
		validate,
	});

	const selectedStorageType = (storageType: string) => {
		const chooseStorage = storageSortedByLabel.find(
			(currentStorage) => currentStorage.value === storageType
		);

		return chooseStorage?.value;
	};

	return (
		<ClayModalProvider>
			<ClayModal observer={observer}>
				<ClayForm onSubmit={handleSubmit}>
					<ClayModal.Header>
						{Liferay.Language.get('new-custom-object')}
					</ClayModal.Header>

					<ClayModal.Body>
						{error && (
							<ClayAlert displayType="danger">{error}</ClayAlert>
						)}

						<Input
							error={errors.label}
							id="objectDefinitionLabel"
							label={Liferay.Language.get('label')}
							name="label"
							onChange={handleChange}
							required
							value={values.label}
						/>

						<Input
							error={errors.pluralLabel}
							id="objectDefinitionPluralLabel"
							label={Liferay.Language.get('plural-label')}
							name="pluralLabel"
							onChange={handleChange}
							required
							value={values.pluralLabel}
						/>

						<Input
							error={errors.name}
							id="objectDefinitionName"
							label={Liferay.Language.get('object-name')}
							name="name"
							onChange={handleChange}
							required
							value={values.name ?? normalizeName(values.label)}
						/>

						{Liferay.FeatureFlags['LPS-135430'] && (
							<div className="lfr__object-web-modal-add-object-definition-storage-type">
								<Select
									label={Liferay.Language.get('storage-type')}
									name="storageType"
									onChange={({target: {value}}) => {
										setValues({
											...values,
											storage: storageSortedByLabel.find(
												(storage) =>
													storage.value === value
											),
										});
									}}
									options={storageSortedByLabel.map(
										(storage) => {
											return {
												key: storage.value,
												label: storage.label,
											};
										}
									)}
									tooltip={Liferay.Language.get(
										'object-definition-storage-type-tooltip'
									)}
									value={selectedStorageType(
										values.storage.value
									)}
								/>

								<div className="lfr__object-web-modal-add-object-definition-storage-type-beta">
									<BetaButton />
								</div>
							</div>
						)}
					</ClayModal.Body>

					<ClayModal.Footer
						last={
							<ClayButton.Group key={1} spaced>
								<ClayButton
									displayType="secondary"
									onClick={() => onClose()}
								>
									{Liferay.Language.get('cancel')}
								</ClayButton>

								<ClayButton displayType="primary" type="submit">
									{Liferay.Language.get('save')}
								</ClayButton>
							</ClayButton.Group>
						}
					/>
				</ClayForm>
			</ClayModal>
		</ClayModalProvider>
	);
}
