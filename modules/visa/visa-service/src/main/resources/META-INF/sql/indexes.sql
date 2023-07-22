create index IX_8C33BBD2 on _visa (cin[$COLUMN_LENGTH:75$]);
create index IX_FE43A0FC on _visa (etat);
create index IX_148FB3EC on _visa (passport[$COLUMN_LENGTH:75$]);
create index IX_CBD24320 on _visa (userId);
create index IX_EA6B855A on _visa (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_77E99A5C on _visa (uuid_[$COLUMN_LENGTH:75$], groupId);