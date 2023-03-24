-- Add all the roles to the application
INSERT INTO role (role_name) VALUES ('Admin'),('Student'),('Staff'),('Faculty');


-- Add Members to the application
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('dummyuser1@gmail.com','John','Doe','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('dummyuser2@gmail.com','John','Doe','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('dummyuser3@gmail.com','Jane','Doe','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('admin@gmail.com','Admin','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkermeal@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkermeditation@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkerflying@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkerclassroom@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkergym@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkerdorm@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checkerlibrary@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');
INSERT INTO member (emailAddress,firstName,lastName,password) VALUES ('checker@gmail.com','Checker','User','$2a$10$KZIujHkbMyCslSu70g3qP.I/t0NQu1PKpK7MzNEszuoGsRZjsWT5q');

-- Provide badges for members
INSERT into badge (badgeId,name,status,member) VALUES ('615420','ID','ACTIVE',4);
INSERT into badge (badgeId,name,status,member) VALUES ('615421','ID','ACTIVE',1);
INSERT into badge (badgeId,name,status,member) VALUES ('615422','ID','ACTIVE',2);
INSERT into badge (badgeId,name,status,member) VALUES ('615423','ID','INACTIVE',1);
INSERT into badge (badgeId,name,status,member) VALUES ('615424','ID','ACTIVE',3);
INSERT into badge (badgeId,name,status,member) VALUES ('615411','ID','ACTIVE',5);
INSERT into badge (badgeId,name,status,member) VALUES ('615412','ID','ACTIVE',6);
INSERT into badge (badgeId,name,status,member) VALUES ('615413','ID','ACTIVE',7);
INSERT into badge (badgeId,name,status,member) VALUES ('615414','ID','ACTIVE',8);
INSERT into badge (badgeId,name,status,member) VALUES ('615415','ID','ACTIVE',9);
INSERT into badge (badgeId,name,status,member) VALUES ('615416','ID','ACTIVE',10);
INSERT into badge (badgeId,name,status,member) VALUES ('615417','ID','ACTIVE',11);
INSERT into badge (badgeId,name,status,member) VALUES ('615418','ID','ACTIVE',12);

-- assign roles to members
INSERT INTO member_role (member_id,roles_id) VALUES (1,2);
INSERT INTO member_role (member_id,roles_id) VALUES (2,3);
INSERT INTO member_role (member_id,roles_id) VALUES (2,4);
INSERT INTO member_role (member_id,roles_id) VALUES (3,4);
INSERT INTO member_role (member_id,roles_id) VALUES (4,1);
INSERT INTO member_role (member_id,roles_id) VALUES (5,1);
INSERT INTO member_role (member_id,roles_id) VALUES (6,1);
INSERT INTO member_role (member_id,roles_id) VALUES (7,1);
INSERT INTO member_role (member_id,roles_id) VALUES (8,1);
INSERT INTO member_role (member_id,roles_id) VALUES (9,1);
INSERT INTO member_role (member_id,roles_id) VALUES (10,1);
INSERT INTO member_role (member_id,roles_id) VALUES (11,1);
INSERT INTO member_role (member_id,roles_id) VALUES (12,1);

-- locations
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the Argiro Main','MAIN','DINING_HALL','Argiro Main Dinning Hall');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (100,'This is the Argiro North','NORTH','DINING_HALL','Argiro North Dinning Hall');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the meditation hall one','DOME_ONE','MEDITATION_HALL','GOLDEN_DOME_ONE');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the meditation hall two','DOME_TWO','MEDITATION_HALL','GOLDEN_DOME_TWO');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the flying hall one','FLYING_ONE','FLYING_HALL','GOLDEN_DOME_ONE');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the flying hall two','FLYING_TWO','FLYING_HALL','GOLDEN_DOME_TWO');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','V11','CLASSROOM','Verill Hall Class 11');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','V12','CLASSROOM','Verill Hall Class 12');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','V13','CLASSROOM','Verill Hall Class 13');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','M115','CLASSROOM','McLaughlin Class 115');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','M116','CLASSROOM','McLaughlin Class 116');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the class','M117','CLASSROOM','McLaughlin Class 117');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (50,'This is the gym','REC1','GYMNASIUM','Gym Hall 1');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (30,'This is the dorm 1','H1','DORMITORY','Dorm H1');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (30,'This is the dorm 2','H2','DORMITORY','Dorm H2');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (30,'This is the class','H3','DORMITORY','Dorm H3');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (30,'This is the class','H4','DORMITORY','Dorm H4');
INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (30,'This is the class','H5','DORMITORY','Dorm H5');

INSERT INTO location (capacity, description, locationId, locationType, name) VALUES (150,'This is the library','LIB1','LIBRARY','MIU Library');

-- time slot of the locations
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','11:00','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','18:00','19:45',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','08:30','10:00',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','11:45','13:30',1);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','18:00','19:45',1);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','11:00','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','18:00','19:45',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','08:30','10:00',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','11:45','13:30',2);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','18:00','19:45',2);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','06:30','15:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','18:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','18:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','18:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','18:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','18:00',3);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','15:00',3);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','06:30','15:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','18:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','18:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','18:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','18:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','18:00',4);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','15:00',4);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','06:30','15:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','18:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','18:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','18:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','18:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','18:00',5);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','15:00',5);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','06:30','15:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','18:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','18:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','18:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','18:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','18:00',6);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','15:00',6);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',7);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',8);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',8);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',8);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',8);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',8);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',8);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',9);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',9);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',9);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',9);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',9);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',9);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',10);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',10);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',10);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',10);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',10);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',10);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',11);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',11);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',11);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',11);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',11);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',11);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',7);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','22:00',12);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','22:00',12);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','22:00',12);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','22:00',12);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','22:00',12);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','22:00',12);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','06:30','15:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','06:30','18:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','06:30','18:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','06:30','18:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','06:30','18:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','06:30','18:00',13);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','06:30','15:00',13);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','01:00','23:59',14);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','01:00','23:59',14);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','01:00','23:59',15);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','01:00','23:59',15);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','01:00','23:59',16);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','01:00','23:59',16);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','01:00','23:59',17);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','01:00','23:59',17);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','01:00','23:59',18);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','01:00','23:59',18);

INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Sunday','00:00','00:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Monday','09:30','18:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Tuesday','09:30','18:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Wednesday','09:30','18:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Thursday','09:30','18:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Friday','09:30','18:00',19);
INSERT INTO time_slot (dayOfTheWeek,startTime,endTime,locationId) VALUES ('Saturday','09:30','16:00',19);

INSERT INTO plans (description, name) VALUES ('All Meal plan description','All Meal');
INSERT INTO plans (description, name) VALUES ('Meditation Hall Plan','Meditation Plan');
INSERT INTO plans (description, name) VALUES ('Flying Hall Plan','Flying Hall Plan');
INSERT INTO plans (description, name) VALUES ('Classroom plan','Classroom Plan');
INSERT INTO plans (description, name) VALUES ('Gym Plan','Gym Plan');
INSERT INTO plans (description, name) VALUES ('Dorm Plan','Dorm Plan');
INSERT INTO plans (description, name) VALUES ('Library Plan','Library Plan');

INSERT INTO plan_location (plans_id, locations_id) VALUES (1,1);
INSERT INTO plan_location (plans_id, locations_id) VALUES (1,2);

INSERT INTO plan_location (plans_id, locations_id) VALUES (2,3);
INSERT INTO plan_location (plans_id, locations_id) VALUES (2,4);

INSERT INTO plan_location (plans_id, locations_id) VALUES (3,5);
INSERT INTO plan_location (plans_id, locations_id) VALUES (3,6);

INSERT INTO plan_location (plans_id, locations_id) VALUES (4,7);
INSERT INTO plan_location (plans_id, locations_id) VALUES (4,8);
INSERT INTO plan_location (plans_id, locations_id) VALUES (4,9);
INSERT INTO plan_location (plans_id, locations_id) VALUES (4,10);
INSERT INTO plan_location (plans_id, locations_id) VALUES (4,11);
INSERT INTO plan_location (plans_id, locations_id) VALUES (4,12);

INSERT INTO plan_location (plans_id, locations_id) VALUES (5,13);

INSERT INTO plan_location (plans_id, locations_id) VALUES (6,14);
INSERT INTO plan_location (plans_id, locations_id) VALUES (6,15);
INSERT INTO plan_location (plans_id, locations_id) VALUES (6,16);
INSERT INTO plan_location (plans_id, locations_id) VALUES (6,17);
INSERT INTO plan_location (plans_id, locations_id) VALUES (6,18);

INSERT INTO plan_location (plans_id, locations_id) VALUES (7,19);



INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (1,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (1,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (1,4);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (2,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (2,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (2,4);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (3,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (3,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (3,4);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (4,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (4,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (4,4);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (5,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (5,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (5,4);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (6,2);

INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (7,2);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (7,3);
INSERT INTO plan_role (plans_id, allowedRoles_id) VALUES (7,4);



INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','LIMITED',20,'2023-03-31',1,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','LIMITED',30,'2023-03-31',1,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','LIMITED',30,'2023-03-31',1,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',1,5);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',1,12);


INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',2,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',2,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',2,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',2,6);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',2,12);


INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',3,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',3,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',3,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',3,7);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',3,12);


INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',4,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',4,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',4,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',4,8);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',4,12);

INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',5,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',5,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',5,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',5,9);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',5,12);

INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',6,1);
-- INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',6,2);
-- INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',6,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',6,10);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',6,12);


INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',7,1);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',7,2);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','UNLIMITED',0,'2023-03-31',7,3);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',7,11);
INSERT INTO membership(startDate, membershipType, numberOfAllowances, endDate, planId, member) values ('2023-03-01','CHECKER',0,'2023-03-31',7,12);


-- INSERT INTO transactions (dateTime, transactionType, planId, badgeId, locationId) VALUES ('2023-03-21T10:34:43.0948726','ACCEPTED',1,2,1);