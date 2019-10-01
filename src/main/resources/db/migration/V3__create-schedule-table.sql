--
-- V3: Create SCHEDULES TABLE
--
--
CREATE TABLE `schedules` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '아이디',
  `title` varchar(1000) NOT NULL COMMENT '제목',
  `content` varchar(1000) NOT NULL COMMENT '내용',
  `rdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
