CREATE DATABASE IF NOT EXISTS `ssafysample`;
USE `ssafysample`;

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies`(
  `mcode` varchar(20) NOT NULL,		#영화 코드
  `mtitle` varchar(20) NOT NULL,	#영화 제목
  `mtime` int NOT NULL,				#영화 시간(분)
  `mdirector` varchar(20) NOT NULL,  #영화 감독
  `mgenre` varchar(20),				#영화 장르
  PRIMARY KEY (`mcode`)
);

INSERT INTO `movies` VALUES ('movie-1','해리포터와 비밀의 방',161,'크리스 콜럼버스', '판타지'),
('movie-2','베테랑2',118,'류승완','액션' ),
('movie-3','비긴 어게인',101,'존 카니','로맨스');

-- -----------------------------------------------------
-- Table `ssafysample`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `members` ;

CREATE TABLE IF NOT EXISTS `members` (
  `member_id` VARCHAR(16) NOT NULL,
  `member_pass` VARCHAR(16) NOT NULL,
  `member_name` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`member_id`));

insert into `members`
values 	('ssafy', '1234','김싸피' ), 
		('admin', '1234','이관리');
select * from movies;
