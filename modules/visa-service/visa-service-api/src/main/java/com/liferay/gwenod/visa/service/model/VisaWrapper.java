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

package com.liferay.gwenod.visa.service.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Visa}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Visa
 * @generated
 */
public class VisaWrapper
	extends BaseModelWrapper<Visa> implements ModelWrapper<Visa>, Visa {

	public VisaWrapper(Visa visa) {
		super(visa);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("visaId", getVisaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("cin", getCin());
		attributes.put("passport", getPassport());
		attributes.put("nom", getNom());
		attributes.put("prenom", getPrenom());
		attributes.put("dateNaissance", getDateNaissance());
		attributes.put("motifVoyage", getMotifVoyage());
		attributes.put("dateVoyage", getDateVoyage());
		attributes.put("dureeVoyage", getDureeVoyage());
		attributes.put("etat", getEtat());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long visaId = (Long)attributes.get("visaId");

		if (visaId != null) {
			setVisaId(visaId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String cin = (String)attributes.get("cin");

		if (cin != null) {
			setCin(cin);
		}

		String passport = (String)attributes.get("passport");

		if (passport != null) {
			setPassport(passport);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenom = (String)attributes.get("prenom");

		if (prenom != null) {
			setPrenom(prenom);
		}

		Date dateNaissance = (Date)attributes.get("dateNaissance");

		if (dateNaissance != null) {
			setDateNaissance(dateNaissance);
		}

		String motifVoyage = (String)attributes.get("motifVoyage");

		if (motifVoyage != null) {
			setMotifVoyage(motifVoyage);
		}

		Date dateVoyage = (Date)attributes.get("dateVoyage");

		if (dateVoyage != null) {
			setDateVoyage(dateVoyage);
		}

		Integer dureeVoyage = (Integer)attributes.get("dureeVoyage");

		if (dureeVoyage != null) {
			setDureeVoyage(dureeVoyage);
		}

		String etat = (String)attributes.get("etat");

		if (etat != null) {
			setEtat(etat);
		}
	}

	@Override
	public Visa cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cin of this visa.
	 *
	 * @return the cin of this visa
	 */
	@Override
	public String getCin() {
		return model.getCin();
	}

	/**
	 * Returns the company ID of this visa.
	 *
	 * @return the company ID of this visa
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this visa.
	 *
	 * @return the create date of this visa
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date naissance of this visa.
	 *
	 * @return the date naissance of this visa
	 */
	@Override
	public Date getDateNaissance() {
		return model.getDateNaissance();
	}

	/**
	 * Returns the date voyage of this visa.
	 *
	 * @return the date voyage of this visa
	 */
	@Override
	public Date getDateVoyage() {
		return model.getDateVoyage();
	}

	/**
	 * Returns the duree voyage of this visa.
	 *
	 * @return the duree voyage of this visa
	 */
	@Override
	public int getDureeVoyage() {
		return model.getDureeVoyage();
	}

	/**
	 * Returns the etat of this visa.
	 *
	 * @return the etat of this visa
	 */
	@Override
	public String getEtat() {
		return model.getEtat();
	}

	/**
	 * Returns the group ID of this visa.
	 *
	 * @return the group ID of this visa
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this visa.
	 *
	 * @return the modified by of this visa
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this visa.
	 *
	 * @return the modified date of this visa
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the motif voyage of this visa.
	 *
	 * @return the motif voyage of this visa
	 */
	@Override
	public String getMotifVoyage() {
		return model.getMotifVoyage();
	}

	/**
	 * Returns the nom of this visa.
	 *
	 * @return the nom of this visa
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the passport of this visa.
	 *
	 * @return the passport of this visa
	 */
	@Override
	public String getPassport() {
		return model.getPassport();
	}

	/**
	 * Returns the prenom of this visa.
	 *
	 * @return the prenom of this visa
	 */
	@Override
	public String getPrenom() {
		return model.getPrenom();
	}

	/**
	 * Returns the primary key of this visa.
	 *
	 * @return the primary key of this visa
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this visa.
	 *
	 * @return the user ID of this visa
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this visa.
	 *
	 * @return the user name of this visa
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this visa.
	 *
	 * @return the user uuid of this visa
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this visa.
	 *
	 * @return the uuid of this visa
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the visa ID of this visa.
	 *
	 * @return the visa ID of this visa
	 */
	@Override
	public long getVisaId() {
		return model.getVisaId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cin of this visa.
	 *
	 * @param cin the cin of this visa
	 */
	@Override
	public void setCin(String cin) {
		model.setCin(cin);
	}

	/**
	 * Sets the company ID of this visa.
	 *
	 * @param companyId the company ID of this visa
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this visa.
	 *
	 * @param createDate the create date of this visa
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date naissance of this visa.
	 *
	 * @param dateNaissance the date naissance of this visa
	 */
	@Override
	public void setDateNaissance(Date dateNaissance) {
		model.setDateNaissance(dateNaissance);
	}

	/**
	 * Sets the date voyage of this visa.
	 *
	 * @param dateVoyage the date voyage of this visa
	 */
	@Override
	public void setDateVoyage(Date dateVoyage) {
		model.setDateVoyage(dateVoyage);
	}

	/**
	 * Sets the duree voyage of this visa.
	 *
	 * @param dureeVoyage the duree voyage of this visa
	 */
	@Override
	public void setDureeVoyage(int dureeVoyage) {
		model.setDureeVoyage(dureeVoyage);
	}

	/**
	 * Sets the etat of this visa.
	 *
	 * @param etat the etat of this visa
	 */
	@Override
	public void setEtat(String etat) {
		model.setEtat(etat);
	}

	/**
	 * Sets the group ID of this visa.
	 *
	 * @param groupId the group ID of this visa
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this visa.
	 *
	 * @param modifiedBy the modified by of this visa
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this visa.
	 *
	 * @param modifiedDate the modified date of this visa
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the motif voyage of this visa.
	 *
	 * @param motifVoyage the motif voyage of this visa
	 */
	@Override
	public void setMotifVoyage(String motifVoyage) {
		model.setMotifVoyage(motifVoyage);
	}

	/**
	 * Sets the nom of this visa.
	 *
	 * @param nom the nom of this visa
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the passport of this visa.
	 *
	 * @param passport the passport of this visa
	 */
	@Override
	public void setPassport(String passport) {
		model.setPassport(passport);
	}

	/**
	 * Sets the prenom of this visa.
	 *
	 * @param prenom the prenom of this visa
	 */
	@Override
	public void setPrenom(String prenom) {
		model.setPrenom(prenom);
	}

	/**
	 * Sets the primary key of this visa.
	 *
	 * @param primaryKey the primary key of this visa
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this visa.
	 *
	 * @param userId the user ID of this visa
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this visa.
	 *
	 * @param userName the user name of this visa
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this visa.
	 *
	 * @param userUuid the user uuid of this visa
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this visa.
	 *
	 * @param uuid the uuid of this visa
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the visa ID of this visa.
	 *
	 * @param visaId the visa ID of this visa
	 */
	@Override
	public void setVisaId(long visaId) {
		model.setVisaId(visaId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected VisaWrapper wrap(Visa visa) {
		return new VisaWrapper(visa);
	}

}