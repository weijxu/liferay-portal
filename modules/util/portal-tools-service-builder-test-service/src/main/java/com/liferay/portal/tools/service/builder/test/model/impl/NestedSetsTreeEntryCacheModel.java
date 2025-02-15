/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.tools.service.builder.test.model.NestedSetsTreeEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NestedSetsTreeEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NestedSetsTreeEntryCacheModel
	implements CacheModel<NestedSetsTreeEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NestedSetsTreeEntryCacheModel)) {
			return false;
		}

		NestedSetsTreeEntryCacheModel nestedSetsTreeEntryCacheModel =
			(NestedSetsTreeEntryCacheModel)object;

		if (nestedSetsTreeEntryId ==
				nestedSetsTreeEntryCacheModel.nestedSetsTreeEntryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, nestedSetsTreeEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{nestedSetsTreeEntryId=");
		sb.append(nestedSetsTreeEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", parentNestedSetsTreeEntryId=");
		sb.append(parentNestedSetsTreeEntryId);
		sb.append(", leftNestedSetsTreeEntryId=");
		sb.append(leftNestedSetsTreeEntryId);
		sb.append(", rightNestedSetsTreeEntryId=");
		sb.append(rightNestedSetsTreeEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NestedSetsTreeEntry toEntityModel() {
		NestedSetsTreeEntryImpl nestedSetsTreeEntryImpl =
			new NestedSetsTreeEntryImpl();

		nestedSetsTreeEntryImpl.setNestedSetsTreeEntryId(nestedSetsTreeEntryId);
		nestedSetsTreeEntryImpl.setGroupId(groupId);
		nestedSetsTreeEntryImpl.setParentNestedSetsTreeEntryId(
			parentNestedSetsTreeEntryId);
		nestedSetsTreeEntryImpl.setLeftNestedSetsTreeEntryId(
			leftNestedSetsTreeEntryId);
		nestedSetsTreeEntryImpl.setRightNestedSetsTreeEntryId(
			rightNestedSetsTreeEntryId);

		nestedSetsTreeEntryImpl.resetOriginalValues();

		return nestedSetsTreeEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		nestedSetsTreeEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		parentNestedSetsTreeEntryId = objectInput.readLong();

		leftNestedSetsTreeEntryId = objectInput.readLong();

		rightNestedSetsTreeEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(nestedSetsTreeEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(parentNestedSetsTreeEntryId);

		objectOutput.writeLong(leftNestedSetsTreeEntryId);

		objectOutput.writeLong(rightNestedSetsTreeEntryId);
	}

	public long nestedSetsTreeEntryId;
	public long groupId;
	public long parentNestedSetsTreeEntryId;
	public long leftNestedSetsTreeEntryId;
	public long rightNestedSetsTreeEntryId;

}