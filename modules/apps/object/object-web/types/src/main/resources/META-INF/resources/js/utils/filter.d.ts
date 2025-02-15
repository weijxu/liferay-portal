/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export declare function getCheckedWorkflowStatusItems(
	itemValues: LabelValueObject[],
	setEditingFilterType: () => number[] | string[] | null
): IItem[];
export declare function getCheckedPickListItems(
	itemValues: PickListItem[],
	setEditingFilterType: () => number[] | string[] | null
): IItem[];
export declare function getSystemFieldLabelFromEntry(
	titleFieldName: string,
	entry: ObjectEntry,
	itemObject: LabelValueObject
): {
	label: unknown;
	value: string;
};
export declare function getCheckedRelationshipItems(
	relatedEntries: ObjectEntry[],
	titleFieldName: string,
	systemField: boolean,
	systemObject: boolean,
	setEditingFilterType: () => number[] | string[] | null
): IItem[];
