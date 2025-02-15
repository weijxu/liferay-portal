/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {SWITCH_VIEWPORT_SIZE} from './types';

import type {ViewportSize} from '../config/constants/viewportSizes';

export default function switchViewportSize({size}: {size: ViewportSize}) {
	return {
		size,
		type: SWITCH_VIEWPORT_SIZE,
	} as const;
}
