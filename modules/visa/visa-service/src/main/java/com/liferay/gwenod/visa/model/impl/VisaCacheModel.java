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

import com.liferay.gwenod.visa.model.Visa;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Visa in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VisaCacheModel implements CacheModel<Visa>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisaCacheModel)) {
			return false;
		}

		VisaCacheModel visaCacheModel = (VisaCacheModel)object;

		if (visaId == visaCacheModel.visaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, visaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", visaId=");
		sb.append(visaId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", cin=");
		sb.append(cin);
		sb.append(", passport=");
		sb.append(passport);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", prenom=");
		sb.append(prenom);
		sb.append(", dateNaissance=");
		sb.append(dateNaissance);
		sb.append(", motifVoyage=");
		sb.append(motifVoyage);
		sb.append(", dateVoyage=");
		sb.append(dateVoyage);
		sb.append(", dureeVoyage=");
		sb.append(dureeVoyage);
		sb.append(", etat=");
		sb.append(etat);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Visa toEntityModel() {
		VisaImpl visaImpl = new VisaImpl();

		if (uuid == null) {
			visaImpl.setUuid("");
		}
		else {
			visaImpl.setUuid(uuid);
		}

		visaImpl.setVisaId(visaId);
		visaImpl.setGroupId(groupId);
		visaImpl.setCompanyId(companyId);
		visaImpl.setUserId(userId);

		if (userName == null) {
			visaImpl.setUserName("");
		}
		else {
			visaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			visaImpl.setCreateDate(null);
		}
		else {
			visaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			visaImpl.setModifiedDate(null);
		}
		else {
			visaImpl.setModifiedDate(new Date(modifiedDate));
		}

		visaImpl.setModifiedBy(modifiedBy);

		if (cin == null) {
			visaImpl.setCin("");
		}
		else {
			visaImpl.setCin(cin);
		}

		if (passport == null) {
			visaImpl.setPassport("");
		}
		else {
			visaImpl.setPassport(passport);
		}

		if (nom == null) {
			visaImpl.setNom("");
		}
		else {
			visaImpl.setNom(nom);
		}

		if (prenom == null) {
			visaImpl.setPrenom("");
		}
		else {
			visaImpl.setPrenom(prenom);
		}

		if (dateNaissance == Long.MIN_VALUE) {
			visaImpl.setDateNaissance(null);
		}
		else {
			visaImpl.setDateNaissance(new Date(dateNaissance));
		}

		if (motifVoyage == null) {
			visaImpl.setMotifVoyage("");
		}
		else {
			visaImpl.setMotifVoyage(motifVoyage);
		}

		if (dateVoyage == Long.MIN_VALUE) {
			visaImpl.setDateVoyage(null);
		}
		else {
			visaImpl.setDateVoyage(new Date(dateVoyage));
		}

		visaImpl.setDureeVoyage(dureeVoyage);
		visaImpl.setEtat(etat);

		visaImpl.resetOriginalValues();

		return visaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		visaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		cin = objectInput.readUTF();
		passport = objectInput.readUTF();
		nom = objectInput.readUTF();
		prenom = objectInput.readUTF();
		dateNaissance = objectInput.readLong();
		motifVoyage = objectInput.readUTF();
		dateVoyage = objectInput.readLong();

		dureeVoyage = objectInput.readInt();

		etat = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(visaId);

		objectOutput.writeLong(groupId);

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

		objectOutput.writeLong(modifiedBy);

		if (cin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cin);
		}

		if (passport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passport);
		}

		if (nom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nom);
		}

		if (prenom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prenom);
		}

		objectOutput.writeLong(dateNaissance);

		if (motifVoyage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motifVoyage);
		}

		objectOutput.writeLong(dateVoyage);

		objectOutput.writeInt(dureeVoyage);

		objectOutput.writeInt(etat);
	}

	public String uuid;
	public long visaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long modifiedBy;
	public String cin;
	public String passport;
	public String nom;
	public String prenom;
	public long dateNaissance;
	public String motifVoyage;
	public long dateVoyage;
	public int dureeVoyage;
	public int etat;

}