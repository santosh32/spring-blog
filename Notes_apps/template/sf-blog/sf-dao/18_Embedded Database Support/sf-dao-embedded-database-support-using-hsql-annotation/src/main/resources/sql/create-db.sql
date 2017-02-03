CREATE TABLE CUSTOMER (
    CUST_ID integer identity primary key,
    NAME varchar(50) not null,
    ADDRESS varchar(255),
    CITY varchar(50) not null,
    STATE varchar(50) not null,
    ZIP_CD varchar(30) not null
);
