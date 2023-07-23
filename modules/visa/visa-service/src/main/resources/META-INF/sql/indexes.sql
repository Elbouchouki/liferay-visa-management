create index IX_5242FD36 on VisaManagement_Visa (cin[$COLUMN_LENGTH:75$]);
create index IX_FA1C8C18 on VisaManagement_Visa (etat);
create index IX_5585B108 on VisaManagement_Visa (passport[$COLUMN_LENGTH:75$]);
create index IX_351CD73C on VisaManagement_Visa (userId);
create index IX_3F90A676 on VisaManagement_Visa (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BEDC5278 on VisaManagement_Visa (uuid_[$COLUMN_LENGTH:75$], groupId);