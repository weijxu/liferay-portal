/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommerceOrderTypeRel service. Represents a row in the &quot;CommerceOrderTypeRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.model.impl.CommerceOrderTypeRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.model.impl.CommerceOrderTypeRelImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceOrderTypeRel
 * @generated
 */
@ProviderType
public interface CommerceOrderTypeRelModel
	extends AttachedModel, BaseModel<CommerceOrderTypeRel>, MVCCModel,
			ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce order type rel model instance should use the {@link CommerceOrderTypeRel} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce order type rel.
	 *
	 * @return the primary key of this commerce order type rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce order type rel.
	 *
	 * @param primaryKey the primary key of this commerce order type rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this commerce order type rel.
	 *
	 * @return the mvcc version of this commerce order type rel
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this commerce order type rel.
	 *
	 * @param mvccVersion the mvcc version of this commerce order type rel
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this commerce order type rel.
	 *
	 * @return the uuid of this commerce order type rel
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce order type rel.
	 *
	 * @param uuid the uuid of this commerce order type rel
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this commerce order type rel.
	 *
	 * @return the external reference code of this commerce order type rel
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this commerce order type rel.
	 *
	 * @param externalReferenceCode the external reference code of this commerce order type rel
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the commerce order type rel ID of this commerce order type rel.
	 *
	 * @return the commerce order type rel ID of this commerce order type rel
	 */
	public long getCommerceOrderTypeRelId();

	/**
	 * Sets the commerce order type rel ID of this commerce order type rel.
	 *
	 * @param commerceOrderTypeRelId the commerce order type rel ID of this commerce order type rel
	 */
	public void setCommerceOrderTypeRelId(long commerceOrderTypeRelId);

	/**
	 * Returns the company ID of this commerce order type rel.
	 *
	 * @return the company ID of this commerce order type rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce order type rel.
	 *
	 * @param companyId the company ID of this commerce order type rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce order type rel.
	 *
	 * @return the user ID of this commerce order type rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce order type rel.
	 *
	 * @param userId the user ID of this commerce order type rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce order type rel.
	 *
	 * @return the user uuid of this commerce order type rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce order type rel.
	 *
	 * @param userUuid the user uuid of this commerce order type rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce order type rel.
	 *
	 * @return the user name of this commerce order type rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce order type rel.
	 *
	 * @param userName the user name of this commerce order type rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce order type rel.
	 *
	 * @return the create date of this commerce order type rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce order type rel.
	 *
	 * @param createDate the create date of this commerce order type rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce order type rel.
	 *
	 * @return the modified date of this commerce order type rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce order type rel.
	 *
	 * @param modifiedDate the modified date of this commerce order type rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this commerce order type rel.
	 *
	 * @return the fully qualified class name of this commerce order type rel
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this commerce order type rel.
	 *
	 * @return the class name ID of this commerce order type rel
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this commerce order type rel.
	 *
	 * @param classNameId the class name ID of this commerce order type rel
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this commerce order type rel.
	 *
	 * @return the class pk of this commerce order type rel
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this commerce order type rel.
	 *
	 * @param classPK the class pk of this commerce order type rel
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the commerce order type ID of this commerce order type rel.
	 *
	 * @return the commerce order type ID of this commerce order type rel
	 */
	public long getCommerceOrderTypeId();

	/**
	 * Sets the commerce order type ID of this commerce order type rel.
	 *
	 * @param commerceOrderTypeId the commerce order type ID of this commerce order type rel
	 */
	public void setCommerceOrderTypeId(long commerceOrderTypeId);

	@Override
	public CommerceOrderTypeRel cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}