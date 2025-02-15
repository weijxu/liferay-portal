/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.asset.category.property.model.impl;

import com.liferay.asset.category.property.model.AssetCategoryProperty;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AssetCategoryProperty in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AssetCategoryPropertyCacheModel
	implements CacheModel<AssetCategoryProperty>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AssetCategoryPropertyCacheModel)) {
			return false;
		}

		AssetCategoryPropertyCacheModel assetCategoryPropertyCacheModel =
			(AssetCategoryPropertyCacheModel)object;

		if ((categoryPropertyId ==
				assetCategoryPropertyCacheModel.categoryPropertyId) &&
			(mvccVersion == assetCategoryPropertyCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, categoryPropertyId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", ctCollectionId=");
		sb.append(ctCollectionId);
		sb.append(", categoryPropertyId=");
		sb.append(categoryPropertyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AssetCategoryProperty toEntityModel() {
		AssetCategoryPropertyImpl assetCategoryPropertyImpl =
			new AssetCategoryPropertyImpl();

		assetCategoryPropertyImpl.setMvccVersion(mvccVersion);
		assetCategoryPropertyImpl.setCtCollectionId(ctCollectionId);
		assetCategoryPropertyImpl.setCategoryPropertyId(categoryPropertyId);
		assetCategoryPropertyImpl.setCompanyId(companyId);
		assetCategoryPropertyImpl.setUserId(userId);

		if (userName == null) {
			assetCategoryPropertyImpl.setUserName("");
		}
		else {
			assetCategoryPropertyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			assetCategoryPropertyImpl.setCreateDate(null);
		}
		else {
			assetCategoryPropertyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			assetCategoryPropertyImpl.setModifiedDate(null);
		}
		else {
			assetCategoryPropertyImpl.setModifiedDate(new Date(modifiedDate));
		}

		assetCategoryPropertyImpl.setCategoryId(categoryId);

		if (key == null) {
			assetCategoryPropertyImpl.setKey("");
		}
		else {
			assetCategoryPropertyImpl.setKey(key);
		}

		if (value == null) {
			assetCategoryPropertyImpl.setValue("");
		}
		else {
			assetCategoryPropertyImpl.setValue(value);
		}

		assetCategoryPropertyImpl.resetOriginalValues();

		return assetCategoryPropertyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		ctCollectionId = objectInput.readLong();

		categoryPropertyId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		categoryId = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(ctCollectionId);

		objectOutput.writeLong(categoryPropertyId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(categoryId);

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long mvccVersion;
	public long ctCollectionId;
	public long categoryPropertyId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public String key;
	public String value;

}