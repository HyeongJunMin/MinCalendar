--
-- V4: Create SCHE_DETAILS TABLE
--
--
CREATE TABLE `mhj_calendar`.`sche_details` (
  `ID` INT NOT NULL AUTO_INCREMENT COMMENT '아이디',
  `ID_SCHEDULES` INT NOT NULL COMMENT 'SCHEDULES 외래키',
  `SDATE` DATETIME NOT NULL COMMENT '일정시작일시',
  `EDATE` DATETIME NOT NULL COMMENT '일정종료일시',
  PRIMARY KEY (`ID`))
COMMENT = 'SCHEDULES에 등록된 일정내용의 세부 일정';
