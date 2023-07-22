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

package com.liferay.gwenod.visa.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;_visa&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Visa
 * @generated
 */
public class VisaTable extends BaseTable<VisaTable> {

	public static final VisaTable INSTANCE = new VisaTable();

	public final Column<VisaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Long> visaId = createColumn(
		"visaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VisaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> cin = createColumn(
		"cin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> passport = createColumn(
		"passport", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> nom = createColumn(
		"nom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> prenom = createColumn(
		"prenom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Date> dateNaissance = createColumn(
		"dateNaissance", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisaTable, String> motifVoyage = createColumn(
		"motifVoyage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Date> dateVoyage = createColumn(
		"dateVoyage", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Integer> dureeVoyage = createColumn(
		"dureeVoyage", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VisaTable, Integer> etat = createColumn(
		"etat", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private VisaTable() {
		super("_visa", VisaTable::new);
	}

}