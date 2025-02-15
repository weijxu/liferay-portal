/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.change.tracking.internal.messaging;

import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.internal.configuration.CTMessageBusConfiguration;
import com.liferay.change.tracking.service.CTMessageLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.change.tracking.CTCollectionThreadLocal;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageBusInterceptor;
import com.liferay.portal.kernel.util.TransientValue;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(
	configurationPid = "com.liferay.change.tracking.internal.configuration.CTMessageBusConfiguration",
	service = MessageBusInterceptor.class
)
public class CTMessageBusInterceptor implements MessageBusInterceptor {

	@Override
	public boolean intercept(
		MessageBus messageBus, String destinationName, Message message) {

		if (!_interceptedDestinationNames.contains(destinationName)) {
			return false;
		}

		long ctCollectionId = CTCollectionThreadLocal.getCTCollectionId();

		if (ctCollectionId == CTConstants.CT_COLLECTION_ID_PRODUCTION) {
			return false;
		}

		message.setDestinationName(destinationName);

		Map<String, Object> messageValues = message.getValues();

		Collection<Object> values = messageValues.values();

		values.removeIf(value -> value instanceof TransientValue);

		_ctMessageLocalService.addCTMessage(ctCollectionId, message);

		return true;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		Set<String> interceptedDestinationNames = new HashSet<>();

		CTMessageBusConfiguration ctMessageBusConfiguration =
			ConfigurableUtil.createConfigurable(
				CTMessageBusConfiguration.class, properties);

		Collections.addAll(
			interceptedDestinationNames,
			ctMessageBusConfiguration.interceptedDestinationNames());

		_interceptedDestinationNames = interceptedDestinationNames;
	}

	@Reference
	private CTMessageLocalService _ctMessageLocalService;

	private volatile Set<String> _interceptedDestinationNames;

}