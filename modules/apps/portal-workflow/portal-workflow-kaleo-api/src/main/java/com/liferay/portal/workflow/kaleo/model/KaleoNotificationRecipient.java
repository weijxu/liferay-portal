/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the KaleoNotificationRecipient service. Represents a row in the &quot;KaleoNotificationRecipient&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNotificationRecipientModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationRecipientImpl"
)
@ProviderType
public interface KaleoNotificationRecipient
	extends KaleoNotificationRecipientModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoNotificationRecipientImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<KaleoNotificationRecipient, Long>
		KALEO_NOTIFICATION_RECIPIENT_ID_ACCESSOR =
			new Accessor<KaleoNotificationRecipient, Long>() {

				@Override
				public Long get(
					KaleoNotificationRecipient kaleoNotificationRecipient) {

					return kaleoNotificationRecipient.
						getKaleoNotificationRecipientId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<KaleoNotificationRecipient> getTypeClass() {
					return KaleoNotificationRecipient.class;
				}

			};

}