/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.security.audit.storage.model.impl;

import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;

/**
 * The extended model base implementation for the AuditEvent service. Represents a row in the &quot;Audit_AuditEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventImpl
 * @see AuditEvent
 * @generated
 */
public abstract class AuditEventBaseImpl
	extends AuditEventModelImpl implements AuditEvent {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audit event model instance should use the <code>AuditEvent</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AuditEventLocalServiceUtil.addAuditEvent(this);
		}
		else {
			AuditEventLocalServiceUtil.updateAuditEvent(this);
		}
	}

}