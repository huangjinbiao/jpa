show create table `user` 
drop  table  if exists `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

# 创建表
drop  table  if exists `person`;
CREATE TABLE person (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
drop  table  if exists `address`;
CREATE TABLE address (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zip_code` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `stree` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
drop  table  if exists `person_address`;
CREATE TABLE person_address(
  `person_id` int(11) NOT NULL ,
  `adress_id`  int(11)  NOT NULL ,
  PRIMARY KEY (`person_id`,`adress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

select * FROM user order by id DESC limit 0,1