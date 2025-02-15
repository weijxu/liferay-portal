/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.asset.link.model.impl;

import com.liferay.asset.link.model.AssetLink;
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
 * The cache model class for representing AssetLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AssetLinkCacheModel
	implements CacheModel<AssetLink>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AssetLinkCacheModel)) {
			return false;
		}

		AssetLinkCacheModel assetLinkCacheModel = (AssetLinkCacheModel)object;

		if ((linkId == assetLinkCacheModel.linkId) &&
			(mvccVersion == assetLinkCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, linkId);

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
		sb.append(", linkId=");
		sb.append(linkId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", entryId1=");
		sb.append(entryId1);
		sb.append(", entryId2=");
		sb.append(entryId2);
		sb.append(", type=");
		sb.append(type);
		sb.append(", weight=");
		sb.append(weight);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AssetLink toEntityModel() {
		AssetLinkImpl assetLinkImpl = new AssetLinkImpl();

		assetLinkImpl.setMvccVersion(mvccVersion);
		assetLinkImpl.setCtCollectionId(ctCollectionId);
		assetLinkImpl.setLinkId(linkId);
		assetLinkImpl.setCompanyId(companyId);
		assetLinkImpl.setUserId(userId);

		if (userName == null) {
			assetLinkImpl.setUserName("");
		}
		else {
			assetLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			assetLinkImpl.setCreateDate(null);
		}
		else {
			assetLinkImpl.setCreateDate(new Date(createDate));
		}

		assetLinkImpl.setEntryId1(entryId1);
		assetLinkImpl.setEntryId2(entryId2);
		assetLinkImpl.setType(type);
		assetLinkImpl.setWeight(weight);

		assetLinkImpl.resetOriginalValues();

		return assetLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		ctCollectionId = objectInput.readLong();

		linkId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		entryId1 = objectInput.readLong();

		entryId2 = objectInput.readLong();

		type = objectInput.readInt();

		weight = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(ctCollectionId);

		objectOutput.writeLong(linkId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(entryId1);

		objectOutput.writeLong(entryId2);

		objectOutput.writeInt(type);

		objectOutput.writeInt(weight);
	}

	public long mvccVersion;
	public long ctCollectionId;
	public long linkId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long entryId1;
	public long entryId2;
	public int type;
	public int weight;

}