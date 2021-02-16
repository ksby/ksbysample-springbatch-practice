create table CUSTOMER
(
    CUSTOMER_ID        int          not null
        primary key,
    FIRST_NAME         varchar(45)  null,
    MIDDLE_NAME        varchar(45)  null,
    LAST_NAME          varchar(45)  null,
    SSN                varchar(45)  null,
    EMAIL_ADDRESS      varchar(256) null,
    HOME_PHONE         char(10)     null,
    CELL_PHONE         char(10)     null,
    WORK_PHONE         char(10)     null,
    NOTIFICATION_PRIEF char         null
);

create table ACCOUNT
(
    ACCOUNT_ID          int       not null,
    BALANCE             float     null,
    LAST_STATEMENT_DATE timestamp null
);

create table CUSTOMER_ACCOUNT
(
    CUSTOMER_CUSTOMER_ID int not null,
    ACCOUNT_ACCOUNT_ID   int not null
);

create table TRANSACTION
(
    TRANSACTION_ID     int       not null,
    ACCOUNT_ACCOUNT_ID int       not null,
    CREDIT             float     null,
    DEBIT              float     null,
    TIMESTAMP          timestamp null
);
