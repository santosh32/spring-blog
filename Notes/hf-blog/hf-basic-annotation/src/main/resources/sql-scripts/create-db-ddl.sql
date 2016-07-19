DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;

DROP TABLE employee;

CREATE TABLE employee (
   ID NUMBER(4) NOT NULL ,
   NAME VARCHAR2(30) NOT NULL,
   joining_date DATE NOT NULL,
   salary NUMBER(10) NOT NULL,
   ssn VARCHAR2(30) NOT NULL,
   PRIMARY KEY (ID)
);