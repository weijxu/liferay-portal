/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.CustomUserAttributes;
import com.liferay.portal.kernel.portlet.UserAttributes;
import com.liferay.portal.kernel.security.RandomUtil;

import java.util.Map;

/**
 * <p>
 * A separate instance of this class is created every time
 * <code>renderRequest.getAttribute(PortletRequest.USER_INFO)</code> is called.
 * It is safe to cache attributes in this instance because you can assume that
 * all calls to this instance belong to the same user.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class DefaultCustomUserAttributes implements CustomUserAttributes {

	@Override
	public Object clone() {
		return new DefaultCustomUserAttributes();
	}

	@Override
	public String getValue(String name, Map<String, String> userInfo) {
		if (name == null) {
			return null;
		}

		if (_log.isDebugEnabled()) {
			String companyId = userInfo.get(UserAttributes.LIFERAY_COMPANY_ID);
			String userId = userInfo.get(UserAttributes.LIFERAY_USER_ID);

			_log.debug("Company id " + companyId);
			_log.debug("User id " + userId);
		}

		if (name.equals("user.name.random")) {
			String[] names = {"Aaa", "Bbb", "Ccc"};

			return names[RandomUtil.nextInt(3)];
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DefaultCustomUserAttributes.class);

}