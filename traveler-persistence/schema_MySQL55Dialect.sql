alter table ACCOUNT drop foreign key FK9rxadd7hdlmarov6qbvaot0po;
alter table ACCOUNT drop foreign key FK4cfkq2sywnlcu6fxm9xbrmsjs;
alter table CITY drop foreign key FKg20pyto8we1mjpxdf0ixmfkgd;
alter table CITY drop foreign key FKi4i6u7b4qdx3pjr1j6qq6y2vm;
alter table STATION drop foreign key FKanu16qi926w9omslreoj7smq1;
alter table STATION drop foreign key FKp7x70rdqw4fidaslc492bnfgk;
alter table STATION drop foreign key FKl8s21emvhb86aubh7m389hrlo;
drop table if exists ACCOUNT;
drop table if exists CITY;
drop table if exists STATION;
create table ACCOUNT (
	ID integer not null auto_increment, 
	CREATED_AT datetime not null, 
	MODIFIED_AT datetime, 
	CREATED_BY integer, 
	MODIFIED_BY integer, 
	primary key (ID)
) engine=InnoDB;
create table CITY (
	ID integer not null auto_increment, 
	CREATED_AT datetime not null, 
	MODIFIED_AT datetime, 
	DISTRICT varchar(32) not null, 
	NAME varchar(32) not null, 
	REGION varchar(32) not null, 
	CREATED_BY integer, 
	MODIFIED_BY integer, 
	primary key (ID)
) engine=InnoDB;
create table STATION (
	ID integer not null auto_increment, 
	CREATED_AT datetime not null, 
	MODIFIED_AT datetime, 
	APARTMENT varchar(16), 
	HOUSE_NO varchar(16), 
	STREET varchar(32), 
	ZIP_CODE varchar(10), 
	X double precision, 
	Y double precision, 
	PHONE varchar(16), 
	TRANSPORT_TYPE varchar(255) not null, 
	CREATED_BY integer, 
	MODIFIED_BY integer, 
	CITY_ID integer, 
	primary key (ID)
) engine=InnoDB;
alter table CITY add constraint UK_snrb33qmm1r4ymfkgkusuplx4 unique (REGION);
alter table ACCOUNT add constraint FK9rxadd7hdlmarov6qbvaot0po foreign key (CREATED_BY) references ACCOUNT (ID);
alter table ACCOUNT add constraint FK4cfkq2sywnlcu6fxm9xbrmsjs foreign key (MODIFIED_BY) references ACCOUNT (ID);
alter table CITY add constraint FKg20pyto8we1mjpxdf0ixmfkgd foreign key (CREATED_BY) references ACCOUNT (ID);
alter table CITY add constraint FKi4i6u7b4qdx3pjr1j6qq6y2vm foreign key (MODIFIED_BY) references ACCOUNT (ID);
alter table STATION add constraint FKanu16qi926w9omslreoj7smq1 foreign key (CREATED_BY) references ACCOUNT (ID);
alter table STATION add constraint FKp7x70rdqw4fidaslc492bnfgk foreign key (MODIFIED_BY) references ACCOUNT (ID);
alter table STATION add constraint FKl8s21emvhb86aubh7m389hrlo foreign key (CITY_ID) references CITY (ID);
