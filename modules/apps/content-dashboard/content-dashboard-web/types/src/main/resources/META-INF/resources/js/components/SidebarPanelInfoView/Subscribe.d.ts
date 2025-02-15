/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import React from 'react';
declare const Subscribe: ({disabled, icon, label, url}: IProps) => JSX.Element;
interface IProps {
	children?: React.ReactNode;
	disabled: boolean;
	icon: string;
	label: string;
	url: RequestInfo;
}
export default Subscribe;
