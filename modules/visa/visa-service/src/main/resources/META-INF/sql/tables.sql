create table VisaManagement_Visa (
	uuid_ VARCHAR(75) null,
	visaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedBy LONG,
	cin VARCHAR(75) null,
	passport VARCHAR(75) null,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null,
	dateNaissance DATE null,
	motifVoyage VARCHAR(75) null,
	dateVoyage DATE null,
	dureeVoyage INTEGER,
	etat INTEGER
);