/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
 
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
 
INSERT INTO USER_PROFILE(type)
VALUES ('DBA');
 
/* Populate one Admin User. We need only one user to demonstrate this example. You can add more as done in previous posts*/
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state)
VALUES ('sam','abc125', 'Sam','Smith','samy@xyz.com', 'Active');
 
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='sam' and profile.type='ADMIN';
  
commit;
