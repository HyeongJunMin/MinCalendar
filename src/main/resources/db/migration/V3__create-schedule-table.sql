--
-- V3: Create SCHEDULES TABLE
--
--
CREATE TABLE schedules (
  id int(11) NOT NULL AUTO_INCREMENT ,
  title varchar(1000) NOT NULL ,
  content varchar(1000) NOT NULL ,
  sche_type varchar(450) NOT NULL,
  rdate timestamp NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;
