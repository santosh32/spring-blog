DROP TABLE "SRLP"."PRODUCT";

  CREATE TABLE "SRLP"."PRODUCT" 
   (	"PROD_ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(50 CHAR) NOT NULL ENABLE, 
	"BRAND" VARCHAR2(50 CHAR) NOT NULL ENABLE, 
	"VARIANT" VARCHAR2(50 CHAR), 
	"PRICE" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "PRODUCT_PK" PRIMARY KEY ("PROD_ID")
	);
 