DROP SCHEMA IF EXISTS `todolist`;

CREATE SCHEMA `todolist`;

use `todolist`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS user (
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(45)  NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `todo`;

CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `date_started` DATETIME,
  `completed`   BOOLEAN,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`user_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

