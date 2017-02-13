drop table STAFF;
drop table customer;
drop table employee;
drop table invoice;
drop table OrderItem;
  


CREATE TABLE "SRLP"."STAFF" 
   (	"STAFF_ID" NUMBER NOT NULL ENABLE, 
	"LAST_NAME" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
	"FIRST_NAME" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
	"CITY" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"STATE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"HOME_PHONE" VARCHAR2(50 BYTE) NOT NULL ENABLE
   );
   
  CREATE TABLE "SRLP"."CUSTOMER" 
   (	"CUSTOMERID" NUMBER NOT NULL ENABLE, 
	"CONTACT" VARCHAR2(50 BYTE), 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"CITY" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"FIRSTORDER" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"STATE" VARCHAR2(30 BYTE), 
	"ZIPCODE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"COUNTRY" VARCHAR2(255 BYTE), 
	"PHONE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"NAME" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "CUSTOMER_PK" PRIMARY KEY ("CUSTOMERID")
   );
   
      CREATE TABLE "SRLP"."EMPLOYEE" 
   (	"EMPID" NUMBER NOT NULL ENABLE, 
	"HIREDATE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"SALARY" VARCHAR2(255 BYTE), 
	"DEPT" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"JOBCODE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"SEX" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"BIRTHDATE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"LASTNAME" VARCHAR2(255 BYTE), 
	"FIRSTNAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"MIDDLENAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"PHONE" VARCHAR2(30 BYTE) NOT NULL ENABLE
   );

CREATE TABLE "SRLP"."INVOICE" 
   (	"INVOICEID" NUMBER NOT NULL ENABLE, 
	"BILLEDTO" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"AMTBILLED" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"COUNTRY" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"AMTINUS" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"BILLEDBY" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"BILLEDON" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"PAIDON" VARCHAR2(500 BYTE) NOT NULL ENABLE
   );
  
  
    CREATE TABLE "SRLP"."ORDERITEM" 
   (	"ORDERID" NUMBER NOT NULL ENABLE, 
	"STOCKID" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"LENGTH" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"FABCHARGES" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"SHIPTO" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"ORDERDATE" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"SHIPPED" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"TAKENBY" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"PROCCESSDBY" VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	"SPECINSTR" VARCHAR2(500 BYTE) NOT NULL ENABLE
   );

 
