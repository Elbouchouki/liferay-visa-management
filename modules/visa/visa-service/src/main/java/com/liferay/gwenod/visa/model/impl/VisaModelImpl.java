/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.visa.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.gwenod.visa.model.Visa;
import com.liferay.gwenod.visa.model.VisaModel;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
 * The base model implementation for the Visa service. Represents a row in the &quot;VisaManagement_Visa&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>VisaModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VisaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisaImpl
 * @generated
 */
@JSON(strict = true)
public class VisaModelImpl extends BaseModelImpl<Visa> implements VisaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a visa model instance should use the <code>Visa</code> interface instead.
	 */
	public static final String TABLE_NAME = "VisaManagement_Visa";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"visaId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedBy", Types.BIGINT}, {"cin", Types.VARCHAR},
		{"passport", Types.VARCHAR}, {"nom", Types.VARCHAR},
		{"prenom", Types.VARCHAR}, {"dateNaissance", Types.TIMESTAMP},
		{"motifVoyage", Types.VARCHAR}, {"dateVoyage", Types.TIMESTAMP},
		{"dureeVoyage", Types.INTEGER}, {"etat", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cin", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("passport", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nom", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("prenom", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dateNaissance", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("motifVoyage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dateVoyage", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dureeVoyage", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("etat", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table VisaManagement_Visa (uuid_ VARCHAR(75) null,visaId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,modifiedBy LONG,cin VARCHAR(75) null,passport VARCHAR(75) null,nom VARCHAR(75) null,prenom VARCHAR(75) null,dateNaissance DATE null,motifVoyage VARCHAR(75) null,dateVoyage DATE null,dureeVoyage INTEGER,etat INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table VisaManagement_Visa";

	public static final String ORDER_BY_JPQL =
		" ORDER BY visa.createDate ASC, visa.etat ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY VisaManagement_Visa.createDate ASC, VisaManagement_Visa.etat ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CIN_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ETAT_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PASSPORT_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 128L;

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

	public VisaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _visaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVisaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _visaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Visa.class;
	}

	@Override
	public String getModelClassName() {
		return Visa.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Visa, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Visa, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Visa, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Visa)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Visa, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Visa, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Visa)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Visa, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Visa, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Visa, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Visa, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Visa, Object>>();

			attributeGetterFunctions.put("uuid", Visa::getUuid);
			attributeGetterFunctions.put("visaId", Visa::getVisaId);
			attributeGetterFunctions.put("groupId", Visa::getGroupId);
			attributeGetterFunctions.put("companyId", Visa::getCompanyId);
			attributeGetterFunctions.put("userId", Visa::getUserId);
			attributeGetterFunctions.put("userName", Visa::getUserName);
			attributeGetterFunctions.put("createDate", Visa::getCreateDate);
			attributeGetterFunctions.put("modifiedDate", Visa::getModifiedDate);
			attributeGetterFunctions.put("modifiedBy", Visa::getModifiedBy);
			attributeGetterFunctions.put("cin", Visa::getCin);
			attributeGetterFunctions.put("passport", Visa::getPassport);
			attributeGetterFunctions.put("nom", Visa::getNom);
			attributeGetterFunctions.put("prenom", Visa::getPrenom);
			attributeGetterFunctions.put(
				"dateNaissance", Visa::getDateNaissance);
			attributeGetterFunctions.put("motifVoyage", Visa::getMotifVoyage);
			attributeGetterFunctions.put("dateVoyage", Visa::getDateVoyage);
			attributeGetterFunctions.put("dureeVoyage", Visa::getDureeVoyage);
			attributeGetterFunctions.put("etat", Visa::getEtat);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Visa, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Visa, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Visa, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Visa, String>)Visa::setUuid);
			attributeSetterBiConsumers.put(
				"visaId", (BiConsumer<Visa, Long>)Visa::setVisaId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Visa, Long>)Visa::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<Visa, Long>)Visa::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Visa, Long>)Visa::setUserId);
			attributeSetterBiConsumers.put(
				"userName", (BiConsumer<Visa, String>)Visa::setUserName);
			attributeSetterBiConsumers.put(
				"createDate", (BiConsumer<Visa, Date>)Visa::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate", (BiConsumer<Visa, Date>)Visa::setModifiedDate);
			attributeSetterBiConsumers.put(
				"modifiedBy", (BiConsumer<Visa, Long>)Visa::setModifiedBy);
			attributeSetterBiConsumers.put(
				"cin", (BiConsumer<Visa, String>)Visa::setCin);
			attributeSetterBiConsumers.put(
				"passport", (BiConsumer<Visa, String>)Visa::setPassport);
			attributeSetterBiConsumers.put(
				"nom", (BiConsumer<Visa, String>)Visa::setNom);
			attributeSetterBiConsumers.put(
				"prenom", (BiConsumer<Visa, String>)Visa::setPrenom);
			attributeSetterBiConsumers.put(
				"dateNaissance",
				(BiConsumer<Visa, Date>)Visa::setDateNaissance);
			attributeSetterBiConsumers.put(
				"motifVoyage", (BiConsumer<Visa, String>)Visa::setMotifVoyage);
			attributeSetterBiConsumers.put(
				"dateVoyage", (BiConsumer<Visa, Date>)Visa::setDateVoyage);
			attributeSetterBiConsumers.put(
				"dureeVoyage", (BiConsumer<Visa, Integer>)Visa::setDureeVoyage);
			attributeSetterBiConsumers.put(
				"etat", (BiConsumer<Visa, Integer>)Visa::setEtat);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getVisaId() {
		return _visaId;
	}

	@Override
	public void setVisaId(long visaId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_visaId = visaId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
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
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public String getCin() {
		if (_cin == null) {
			return "";
		}
		else {
			return _cin;
		}
	}

	@Override
	public void setCin(String cin) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cin = cin;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalCin() {
		return getColumnOriginalValue("cin");
	}

	@JSON
	@Override
	public String getPassport() {
		if (_passport == null) {
			return "";
		}
		else {
			return _passport;
		}
	}

	@Override
	public void setPassport(String passport) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_passport = passport;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPassport() {
		return getColumnOriginalValue("passport");
	}

	@JSON
	@Override
	public String getNom() {
		if (_nom == null) {
			return "";
		}
		else {
			return _nom;
		}
	}

	@Override
	public void setNom(String nom) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nom = nom;
	}

	@JSON
	@Override
	public String getPrenom() {
		if (_prenom == null) {
			return "";
		}
		else {
			return _prenom;
		}
	}

	@Override
	public void setPrenom(String prenom) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prenom = prenom;
	}

	@JSON
	@Override
	public Date getDateNaissance() {
		return _dateNaissance;
	}

	@Override
	public void setDateNaissance(Date dateNaissance) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dateNaissance = dateNaissance;
	}

	@JSON
	@Override
	public String getMotifVoyage() {
		if (_motifVoyage == null) {
			return "";
		}
		else {
			return _motifVoyage;
		}
	}

	@Override
	public void setMotifVoyage(String motifVoyage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_motifVoyage = motifVoyage;
	}

	@JSON
	@Override
	public Date getDateVoyage() {
		return _dateVoyage;
	}

	@Override
	public void setDateVoyage(Date dateVoyage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dateVoyage = dateVoyage;
	}

	@JSON
	@Override
	public int getDureeVoyage() {
		return _dureeVoyage;
	}

	@Override
	public void setDureeVoyage(int dureeVoyage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dureeVoyage = dureeVoyage;
	}

	@JSON
	@Override
	public int getEtat() {
		return _etat;
	}

	@Override
	public void setEtat(int etat) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_etat = etat;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalEtat() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("etat"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Visa.class.getName()));
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
			getCompanyId(), Visa.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Visa toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Visa>
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
		VisaImpl visaImpl = new VisaImpl();

		visaImpl.setUuid(getUuid());
		visaImpl.setVisaId(getVisaId());
		visaImpl.setGroupId(getGroupId());
		visaImpl.setCompanyId(getCompanyId());
		visaImpl.setUserId(getUserId());
		visaImpl.setUserName(getUserName());
		visaImpl.setCreateDate(getCreateDate());
		visaImpl.setModifiedDate(getModifiedDate());
		visaImpl.setModifiedBy(getModifiedBy());
		visaImpl.setCin(getCin());
		visaImpl.setPassport(getPassport());
		visaImpl.setNom(getNom());
		visaImpl.setPrenom(getPrenom());
		visaImpl.setDateNaissance(getDateNaissance());
		visaImpl.setMotifVoyage(getMotifVoyage());
		visaImpl.setDateVoyage(getDateVoyage());
		visaImpl.setDureeVoyage(getDureeVoyage());
		visaImpl.setEtat(getEtat());

		visaImpl.resetOriginalValues();

		return visaImpl;
	}

	@Override
	public Visa cloneWithOriginalValues() {
		VisaImpl visaImpl = new VisaImpl();

		visaImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		visaImpl.setVisaId(this.<Long>getColumnOriginalValue("visaId"));
		visaImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		visaImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		visaImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		visaImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		visaImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		visaImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		visaImpl.setModifiedBy(this.<Long>getColumnOriginalValue("modifiedBy"));
		visaImpl.setCin(this.<String>getColumnOriginalValue("cin"));
		visaImpl.setPassport(this.<String>getColumnOriginalValue("passport"));
		visaImpl.setNom(this.<String>getColumnOriginalValue("nom"));
		visaImpl.setPrenom(this.<String>getColumnOriginalValue("prenom"));
		visaImpl.setDateNaissance(
			this.<Date>getColumnOriginalValue("dateNaissance"));
		visaImpl.setMotifVoyage(
			this.<String>getColumnOriginalValue("motifVoyage"));
		visaImpl.setDateVoyage(this.<Date>getColumnOriginalValue("dateVoyage"));
		visaImpl.setDureeVoyage(
			this.<Integer>getColumnOriginalValue("dureeVoyage"));
		visaImpl.setEtat(this.<Integer>getColumnOriginalValue("etat"));

		return visaImpl;
	}

	@Override
	public int compareTo(Visa visa) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), visa.getCreateDate());

		if (value != 0) {
			return value;
		}

		if (getEtat() < visa.getEtat()) {
			value = -1;
		}
		else if (getEtat() > visa.getEtat()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(object instanceof Visa)) {
			return false;
		}

		Visa visa = (Visa)object;

		long primaryKey = visa.getPrimaryKey();

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
	public CacheModel<Visa> toCacheModel() {
		VisaCacheModel visaCacheModel = new VisaCacheModel();

		visaCacheModel.uuid = getUuid();

		String uuid = visaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			visaCacheModel.uuid = null;
		}

		visaCacheModel.visaId = getVisaId();

		visaCacheModel.groupId = getGroupId();

		visaCacheModel.companyId = getCompanyId();

		visaCacheModel.userId = getUserId();

		visaCacheModel.userName = getUserName();

		String userName = visaCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			visaCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			visaCacheModel.createDate = createDate.getTime();
		}
		else {
			visaCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			visaCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			visaCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		visaCacheModel.modifiedBy = getModifiedBy();

		visaCacheModel.cin = getCin();

		String cin = visaCacheModel.cin;

		if ((cin != null) && (cin.length() == 0)) {
			visaCacheModel.cin = null;
		}

		visaCacheModel.passport = getPassport();

		String passport = visaCacheModel.passport;

		if ((passport != null) && (passport.length() == 0)) {
			visaCacheModel.passport = null;
		}

		visaCacheModel.nom = getNom();

		String nom = visaCacheModel.nom;

		if ((nom != null) && (nom.length() == 0)) {
			visaCacheModel.nom = null;
		}

		visaCacheModel.prenom = getPrenom();

		String prenom = visaCacheModel.prenom;

		if ((prenom != null) && (prenom.length() == 0)) {
			visaCacheModel.prenom = null;
		}

		Date dateNaissance = getDateNaissance();

		if (dateNaissance != null) {
			visaCacheModel.dateNaissance = dateNaissance.getTime();
		}
		else {
			visaCacheModel.dateNaissance = Long.MIN_VALUE;
		}

		visaCacheModel.motifVoyage = getMotifVoyage();

		String motifVoyage = visaCacheModel.motifVoyage;

		if ((motifVoyage != null) && (motifVoyage.length() == 0)) {
			visaCacheModel.motifVoyage = null;
		}

		Date dateVoyage = getDateVoyage();

		if (dateVoyage != null) {
			visaCacheModel.dateVoyage = dateVoyage.getTime();
		}
		else {
			visaCacheModel.dateVoyage = Long.MIN_VALUE;
		}

		visaCacheModel.dureeVoyage = getDureeVoyage();

		visaCacheModel.etat = getEtat();

		return visaCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Visa, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Visa, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Visa, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Visa)this);

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

		private static final Function<InvocationHandler, Visa>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Visa.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _visaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private String _cin;
	private String _passport;
	private String _nom;
	private String _prenom;
	private Date _dateNaissance;
	private String _motifVoyage;
	private Date _dateVoyage;
	private int _dureeVoyage;
	private int _etat;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Visa, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Visa)this);
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

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("visaId", _visaId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
		_columnOriginalValues.put("cin", _cin);
		_columnOriginalValues.put("passport", _passport);
		_columnOriginalValues.put("nom", _nom);
		_columnOriginalValues.put("prenom", _prenom);
		_columnOriginalValues.put("dateNaissance", _dateNaissance);
		_columnOriginalValues.put("motifVoyage", _motifVoyage);
		_columnOriginalValues.put("dateVoyage", _dateVoyage);
		_columnOriginalValues.put("dureeVoyage", _dureeVoyage);
		_columnOriginalValues.put("etat", _etat);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("visaId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("modifiedBy", 256L);

		columnBitmasks.put("cin", 512L);

		columnBitmasks.put("passport", 1024L);

		columnBitmasks.put("nom", 2048L);

		columnBitmasks.put("prenom", 4096L);

		columnBitmasks.put("dateNaissance", 8192L);

		columnBitmasks.put("motifVoyage", 16384L);

		columnBitmasks.put("dateVoyage", 32768L);

		columnBitmasks.put("dureeVoyage", 65536L);

		columnBitmasks.put("etat", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Visa _escapedModel;

}