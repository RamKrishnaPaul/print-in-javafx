/*
SQLyog Community Edition- MySQL GUI v8.01 
MySQL - 5.6.24-log : Database - ram
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ram` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ram`;

/*Table structure for table `crudmvc` */

DROP TABLE IF EXISTS `crudmvc`;

CREATE TABLE `crudmvc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5000) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL,
  `Designation` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `crudmvc` */

insert  into `crudmvc`(`id`,`name`,`Salary`,`Designation`) values (7,'Ram Krishna Paul',35000,'Developer');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
