
  CREATE TABLE "SRLP"."MOVIE" 
   (	"MOVIE_ID" NUMBER NOT NULL ENABLE, 
	"TITLE" VARCHAR2(150 CHAR) NOT NULL ENABLE, 
	"DIRECTOR" VARCHAR2(100 CHAR), 
	"GENRE" VARCHAR2(100 CHAR), 
	"RAITING" VARCHAR2(100 CHAR), 
	"STATUS" VARCHAR2(20 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS NOLOGGING
  TABLESPACE "EXAMPLE" ;