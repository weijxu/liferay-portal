/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {Liferay} from '../..';
import MDFRequest from '../../../../interfaces/mdfRequest';
import {getDTOFromMDFRequest} from '../../../../utils/dto/mdf-request/getDTOFromMDFRequest';
import {LiferayAPIs} from '../../common/enums/apis';
import liferayFetcher from '../../common/utils/fetcher';
import {ResourceName} from '../enum/resourceName';

export default async function createMDFRequest(
	apiOption: ResourceName,
	mdfRequest: MDFRequest,
	externalReferenceCodeFromSF?: string
) {
	return await liferayFetcher.post(
		`/o/${LiferayAPIs.OBJECT}/${apiOption}`,
		Liferay.authToken,
		getDTOFromMDFRequest(mdfRequest, externalReferenceCodeFromSF)
	);
}
