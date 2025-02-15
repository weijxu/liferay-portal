/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.language.override.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.language.override.model.PLOEntry;
import com.liferay.portal.language.override.model.PLOEntryModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PLOEntry service. Represents a row in the &quot;PLOEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PLOEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PLOEntryImpl}.
 * </p>
 *
 * @author Drew Brokke
 * @see PLOEntryImpl
 * @generated
 */
@JSON(strict = true)
public class PLOEntryModelImpl
	extends BaseModelImpl<PLOEntry> implements PLOEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a plo entry model instance should use the <code>PLOEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "PLOEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ploEntryId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"key_", Types.VARCHAR}, {"languageId", Types.VARCHAR},
		{"value", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ploEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("value", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PLOEntry (mvccVersion LONG default 0 not null,ploEntryId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,key_ VARCHAR(1000) null,languageId VARCHAR(75) null,value TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table PLOEntry";

	public static final String ORDER_BY_JPQL = " ORDER BY ploEntry.key ASC";

	public static final String ORDER_BY_SQL = " ORDER BY PLOEntry.key_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long KEY_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LANGUAGEID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public PLOEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ploEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPloEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ploEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PLOEntry.class;
	}

	@Override
	public String getModelClassName() {
		return PLOEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PLOEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PLOEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PLOEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((PLOEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PLOEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PLOEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PLOEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PLOEntry, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PLOEntry, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<PLOEntry, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<PLOEntry, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<PLOEntry, Object>>();

			attributeGetterFunctions.put(
				"mvccVersion", PLOEntry::getMvccVersion);
			attributeGetterFunctions.put("ploEntryId", PLOEntry::getPloEntryId);
			attributeGetterFunctions.put("companyId", PLOEntry::getCompanyId);
			attributeGetterFunctions.put("userId", PLOEntry::getUserId);
			attributeGetterFunctions.put("createDate", PLOEntry::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", PLOEntry::getModifiedDate);
			attributeGetterFunctions.put("key", PLOEntry::getKey);
			attributeGetterFunctions.put("languageId", PLOEntry::getLanguageId);
			attributeGetterFunctions.put("value", PLOEntry::getValue);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<PLOEntry, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<PLOEntry, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PLOEntry, ?>>();

			attributeSetterBiConsumers.put(
				"mvccVersion",
				(BiConsumer<PLOEntry, Long>)PLOEntry::setMvccVersion);
			attributeSetterBiConsumers.put(
				"ploEntryId",
				(BiConsumer<PLOEntry, Long>)PLOEntry::setPloEntryId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<PLOEntry, Long>)PLOEntry::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<PLOEntry, Long>)PLOEntry::setUserId);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<PLOEntry, Date>)PLOEntry::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<PLOEntry, Date>)PLOEntry::setModifiedDate);
			attributeSetterBiConsumers.put(
				"key", (BiConsumer<PLOEntry, String>)PLOEntry::setKey);
			attributeSetterBiConsumers.put(
				"languageId",
				(BiConsumer<PLOEntry, String>)PLOEntry::setLanguageId);
			attributeSetterBiConsumers.put(
				"value", (BiConsumer<PLOEntry, String>)PLOEntry::setValue);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getPloEntryId() {
		return _ploEntryId;
	}

	@Override
	public void setPloEntryId(long ploEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ploEntryId = ploEntryId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_key = key;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalKey() {
		return getColumnOriginalValue("key_");
	}

	@JSON
	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_languageId = languageId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLanguageId() {
		return getColumnOriginalValue("languageId");
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_value = value;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), PLOEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PLOEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PLOEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PLOEntryImpl ploEntryImpl = new PLOEntryImpl();

		ploEntryImpl.setMvccVersion(getMvccVersion());
		ploEntryImpl.setPloEntryId(getPloEntryId());
		ploEntryImpl.setCompanyId(getCompanyId());
		ploEntryImpl.setUserId(getUserId());
		ploEntryImpl.setCreateDate(getCreateDate());
		ploEntryImpl.setModifiedDate(getModifiedDate());
		ploEntryImpl.setKey(getKey());
		ploEntryImpl.setLanguageId(getLanguageId());
		ploEntryImpl.setValue(getValue());

		ploEntryImpl.resetOriginalValues();

		return ploEntryImpl;
	}

	@Override
	public PLOEntry cloneWithOriginalValues() {
		PLOEntryImpl ploEntryImpl = new PLOEntryImpl();

		ploEntryImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		ploEntryImpl.setPloEntryId(
			this.<Long>getColumnOriginalValue("ploEntryId"));
		ploEntryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		ploEntryImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		ploEntryImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		ploEntryImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		ploEntryImpl.setKey(this.<String>getColumnOriginalValue("key_"));
		ploEntryImpl.setLanguageId(
			this.<String>getColumnOriginalValue("languageId"));
		ploEntryImpl.setValue(this.<String>getColumnOriginalValue("value"));

		return ploEntryImpl;
	}

	@Override
	public int compareTo(PLOEntry ploEntry) {
		int value = 0;

		value = getKey().compareTo(ploEntry.getKey());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PLOEntry)) {
			return false;
		}

		PLOEntry ploEntry = (PLOEntry)object;

		long primaryKey = ploEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<PLOEntry> toCacheModel() {
		PLOEntryCacheModel ploEntryCacheModel = new PLOEntryCacheModel();

		ploEntryCacheModel.mvccVersion = getMvccVersion();

		ploEntryCacheModel.ploEntryId = getPloEntryId();

		ploEntryCacheModel.companyId = getCompanyId();

		ploEntryCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ploEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			ploEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ploEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ploEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ploEntryCacheModel.key = getKey();

		String key = ploEntryCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			ploEntryCacheModel.key = null;
		}

		ploEntryCacheModel.languageId = getLanguageId();

		String languageId = ploEntryCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			ploEntryCacheModel.languageId = null;
		}

		ploEntryCacheModel.value = getValue();

		String value = ploEntryCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			ploEntryCacheModel.value = null;
		}

		return ploEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PLOEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PLOEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PLOEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((PLOEntry)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PLOEntry>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					PLOEntry.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _ploEntryId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _key;
	private String _languageId;
	private String _value;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PLOEntry, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PLOEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("ploEntryId", _ploEntryId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("key_", _key);
		_columnOriginalValues.put("languageId", _languageId);
		_columnOriginalValues.put("value", _value);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("key_", "key");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("ploEntryId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("key_", 64L);

		columnBitmasks.put("languageId", 128L);

		columnBitmasks.put("value", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PLOEntry _escapedModel;

}