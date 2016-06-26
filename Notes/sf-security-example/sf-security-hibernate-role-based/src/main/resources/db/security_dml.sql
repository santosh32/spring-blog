/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(id,type)
VALUES (1, 'USER');
 
INSERT INTO USER_PROFILE(id,type)
VALUES (2, 'ADMIN');
 
INSERT INTO USER_PROFILE(id,type)
VALUES (3, 'DBA');
 
/* Populate APP_USER Table */
INSERT INTO APP_USER(id,sso_id, password, first_name, last_name, email, state)
VALUES (1,'bill','password', 'bill','Watcher','bill@xyz.com', 'Active');
 
INSERT INTO APP_USER(id,sso_id, password, first_name, last_name, email, state)
VALUES (2,'danny','password', 'Danny','Theys','danny@xyz.com', 'Active');
 
INSERT INTO APP_USER(id,sso_id, password, first_name, last_name, email, state)
VALUES (3,'sam','password', 'Sam','Smith','samy@xyz.com', 'Active');
 
INSERT INTO APP_USER(id,sso_id, password, first_name, last_name, email, state)
VALUES (4,'nicole','password', 'Nicole','warner','nicloe@xyz.com', 'Active');
 
INSERT INTO APP_USER(id,sso_id, password, first_name, last_name, email, state)
VALUES (5,'kenny','password', 'Kenny','Roger','kenny@xyz.com', 'Active');
 
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='bill' and p.type='USER';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='danny' and p.type='USER';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='sam' and p.type='ADMIN';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='nicole' and p.type='DBA';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='kenny' and p.type='ADMIN';
 
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT u.id, p.id FROM app_user u, user_profile p  
  where u.sso_id='kenny' and p.type='DBA';
  
commit;