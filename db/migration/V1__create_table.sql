create table CUSTOMER
(
    CUSTOMER_ID       int          not null
        primary key,
    FIRST_NAME        varchar(45)  null,
    MIDDLE_NAME       varchar(45)  null,
    LAST_NAME         varchar(45)  null,
    ADDRESS1          varchar(45)  null,
    ADDRESS2          varchar(45)  null,
    CITY              varchar(45)  null,
    STATE             varchar(45)  null,
    POSTAL_CODE       varchar(45)  null,
    SSN               varchar(45)  null,
    EMAIL_ADDRESS     varchar(256) null,
    HOME_PHONE        char(15)     null,
    CELL_PHONE        char(15)     null,
    WORK_PHONE        char(15)     null,
    NOTIFICATION_PREF char         null
);
insert into CUSTOMER(CUSTOMER_ID)
values (2);
insert into CUSTOMER(CUSTOMER_ID)
values (441);
insert into CUSTOMER(CUSTOMER_ID)
values (174);
insert into CUSTOMER(CUSTOMER_ID)
values (287);
insert into CUSTOMER(CUSTOMER_ID)
values (168);
insert into CUSTOMER(CUSTOMER_ID)
values (204);

create table ACCOUNT
(
    ACCOUNT_ID          int       not null,
    BALANCE             float     null,
    LAST_STATEMENT_DATE timestamp null
);
insert into ACCOUNT(ACCOUNT_ID, BALANCE)
values (405, 0);
insert into ACCOUNT(ACCOUNT_ID, BALANCE)
values (584, 0);

create table CUSTOMER_ACCOUNT
(
    CUSTOMER_CUSTOMER_ID int not null,
    ACCOUNT_ACCOUNT_ID   int not null
);
insert into CUSTOMER_ACCOUNT values (174, 405);
insert into CUSTOMER_ACCOUNT values (204, 584);

create table TRANSACTION
(
    TRANSACTION_ID     int          not null,
    ACCOUNT_ACCOUNT_ID int          not null,
    DESCRIPTION        varchar(256) null,
    CREDIT             float        null,
    DEBIT              float        null,
    TIMESTAMP          timestamp    null
);
