CREATE TABLE DISGROUP (ID INTEGER AUTO_INCREMENT NOT NULL, MOVIEID BIGINT, NAME VARCHAR(255), CREATED BIGINT, PRIMARY KEY (ID))
CREATE TABLE POPULARMOVIE (ID INTEGER AUTO_INCREMENT NOT NULL, MOVIEID BIGINT, TITLE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE USER (ID BIGINT AUTO_INCREMENT NOT NULL, DTYPE VARCHAR(31), PASSWORD VARCHAR(255), USERNAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE MEMBER (ID BIGINT NOT NULL, NIKENAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE USER2MOVIE (ID INTEGER AUTO_INCREMENT NOT NULL, MOVIE BIGINT, USER BIGINT, PRIMARY KEY (ID))
CREATE TABLE COMMENT (CID INTEGER AUTO_INCREMENT NOT NULL, CONTENT VARCHAR(255), PRIMARY KEY (CID))
CREATE TABLE COMMENT2USER (ID INTEGER AUTO_INCREMENT NOT NULL, UID VARCHAR(255), CID INTEGER, PRIMARY KEY (ID))
CREATE TABLE COMMENT2PEOPLE (ID INTEGER AUTO_INCREMENT NOT NULL, PID VARCHAR(255), CID INTEGER, PRIMARY KEY (ID))
CREATE TABLE GROUP2MEMBER (GROUP_ID INTEGER NOT NULL, USER_ID BIGINT NOT NULL, PRIMARY KEY (GROUP_ID, USER_ID))
ALTER TABLE DISGROUP ADD CONSTRAINT FK_DISGROUP_CREATED FOREIGN KEY (CREATED) REFERENCES USER (ID)
ALTER TABLE MEMBER ADD CONSTRAINT FK_MEMBER_ID FOREIGN KEY (ID) REFERENCES USER (ID)
ALTER TABLE USER2MOVIE ADD CONSTRAINT FK_USER2MOVIE_USER FOREIGN KEY (USER) REFERENCES USER (ID)
ALTER TABLE COMMENT2USER ADD CONSTRAINT FK_COMMENT2USER_CID FOREIGN KEY (CID) REFERENCES COMMENT (CID)
ALTER TABLE COMMENT2PEOPLE ADD CONSTRAINT FK_COMMENT2PEOPLE_CID FOREIGN KEY (CID) REFERENCES COMMENT (CID)
ALTER TABLE GROUP2MEMBER ADD CONSTRAINT FK_GROUP2MEMBER_USER_ID FOREIGN KEY (USER_ID) REFERENCES USER (ID)
ALTER TABLE GROUP2MEMBER ADD CONSTRAINT FK_GROUP2MEMBER_GROUP_ID FOREIGN KEY (GROUP_ID) REFERENCES DISGROUP (ID)
