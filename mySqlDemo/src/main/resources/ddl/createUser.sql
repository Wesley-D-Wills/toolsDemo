CREATE DATABASE IF NOT EXISTS `demo`;

USE `demo`;

CREATE TABLE IF NOT EXISTS `tb_user` (
    `id` int(32) NOT NULL AUTO_INCREMENT,
    `username` varchar(32) NOT NULL,
    `age` INT ,
    `email` varchar(32) DEFAULT NULL,
    `address` varchar(64) DEFAULT NULL,
    `tel_num` varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;