
  CREATE TABLE "SRLP"."MOVIE" 
   (	"MOVIE_ID" NUMBER NOT NULL ENABLE, 
	"TITLE" VARCHAR2(150 CHAR) NOT NULL ENABLE, 
	"DIRECTOR" VARCHAR2(100 CHAR), 
	"GENRE" VARCHAR2(100 CHAR), 
	"RAITING" VARCHAR2(100 CHAR), 
	"BOX_OFFICE" VARCHAR2(100 CHAR), 
	 CONSTRAINT "MOVIE_PK" PRIMARY KEY ("MOVIE_ID")
   );
  
   CREATE SEQUENCE  "SRLP"."MOVIE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 65 CACHE 20 NOORDER  NOCYCLE ;
 
