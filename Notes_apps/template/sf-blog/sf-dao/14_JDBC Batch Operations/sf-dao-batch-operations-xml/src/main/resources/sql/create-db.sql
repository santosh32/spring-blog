
  CREATE TABLE "SRLP"."PRODUCTS" 
   (	"PROD_ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"PRICE" NUMBER NOT NULL ENABLE, 
	"BRAND" VARCHAR2(50 BYTE) NOT NULL ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS NOLOGGING
  TABLESPACE "EXAMPLE" ;
 
