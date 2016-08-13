Insert into TAG (ID,NAME) values (50,'Spring projects');
Insert into TAG (ID,NAME) values (100,'Spring projects');
Insert into TAG (ID,NAME) values (101,'Apache projects');
Insert into TAG (ID,NAME) values (102,'Open source');

Insert into NOTE (ID,BODY,TITLE) values (250,'Takes an opinionated view of building production-ready Spring applications.','Spring Boot');
Insert into NOTE (ID,BODY,TITLE) values (251,'Core support for dependency injection, transaction management, web applications, data access, messaging, testing and more.','Spring Framework');
Insert into NOTE (ID,BODY,TITLE) values (252,'Extends the Spring programming model to support the well-known Enterprise Integration Patterns.','Spring Integration');
Insert into NOTE (ID,BODY,TITLE) values (253,'Apache Tomcat is an open source software implementation of the Java Servlet and JavaServer Pages technologies.','Tomcat');

Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (250,100);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (250,102);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (251,100);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (251,102);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (252,100);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (252,102);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (253,101);
Insert into NOTE_TAGS (NOTES_ID,TAGS_ID) values (253,102);