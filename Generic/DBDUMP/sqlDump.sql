/*
SQLyog Community Edition- MySQL GUI v6.07
Host - 5.5.20 : Database - server
*********************************************************************
Server version : 5.5.20
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `server`;

USE `server`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `form` */

DROP TABLE IF EXISTS `form`;

CREATE TABLE `form` (
  `formid` int(10) NOT NULL,
  `formname` varchar(40) DEFAULT NULL,
  `no_of_fields` int(10) DEFAULT NULL,
  PRIMARY KEY (`formid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `form` */

insert  into `form`(`formid`,`formname`,`no_of_fields`) values (10,'ramtech',1),(11,'ravi',2),(12,'Bash',3),(101,'ravi',1),(110,'sarsd',1),(112,'sldfks',1);

/*Table structure for table `formdetails` */

DROP TABLE IF EXISTS `formdetails`;

CREATE TABLE `formdetails` (
  `formid` int(10) DEFAULT NULL,
  `lineid` int(10) DEFAULT NULL,
  `field` varchar(40) DEFAULT NULL,
  `field_length` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `formdetails` */

insert  into `formdetails`(`formid`,`lineid`,`field`,`field_length`) values (1,0,'basha',10),(1,0,'ela',10),(2,0,'basha1',10),(2,0,'ela1',10),(2,0,'amar',10),(3,0,'generic',30),(3,0,'generic1',30),(3,0,'generic2',30),(2,0,'E',30),(2,0,'E1',30),(10,0,'ravi',2),(10,0,'rav',3),(101,0,'ravi',4),(101,0,'raju',4),(101,0,'ravi',5),(10,0,'rajesh',5),(12,0,'ela',5),(12,0,'rvi',3),(12,0,'kalyan',4),(11,0,'ravi',4),(11,0,'kumar',2),(112,0,'ravi',5),(110,0,'ravsdf',5);

/*Table structure for table `listdetails` */

DROP TABLE IF EXISTS `listdetails`;

CREATE TABLE `listdetails` (
  `listno` int(25) DEFAULT NULL,
  `line_id` int(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `listdetails` */

insert  into `listdetails`(`listno`,`line_id`,`email`,`name`) values (100,6,'basha@gmail.com','basha'),(100,6,'ela@gmail.com','ela'),(101,6,'basha@gmail.com','basha'),(101,6,'ela@gmail.com','ela'),(101,6,'basha@gmail.com','basha'),(101,6,'ela@gmail.com','ela'),(102,6,'ramjan@gmail.com','ramjan'),(102,6,'basha@gmail.com','basha'),(102,6,'rafi@gmail.com','rafi'),(102,6,'mohammad@gmail.com','mohammad'),(101,6,'basha@gmail.com','basha'),(101,6,'ela@gmail.com','ela'),(10,6,'sdfsad@gmail.com','rarav'),(10,6,'sadf@gamisa,cin','raf'),(110,6,'raj@gmail.com','raj'),(112,6,'ram@gmail.com','ram'),(112,6,'vijn@gmail.com','vijn');

/*Table structure for table `listmaster` */

DROP TABLE IF EXISTS `listmaster`;

CREATE TABLE `listmaster` (
  `listno` int(25) NOT NULL,
  `listname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`listno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `listmaster` */

insert  into `listmaster`(`listno`,`listname`) values (10,'adf'),(101,'tomcat'),(110,'rasdfsd'),(112,'ramtech');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `messageid` int(10) DEFAULT NULL,
  `content` varchar(600) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `listname` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `message` */

insert  into `message`(`messageid`,`content`,`status`,`listname`) values (0,'sag:sadg:',0,'tomcat'),(0,'generic:generic1:generic2:Ec:Ec1:',0,'tomcat1'),(1,'basha1:E1:amar:',0,'Etools'),(0,'sdfa:sdafsa:',0,'tomcat'),(0,'ravi:kalyan:manju:A:A1:',0,'tomcat1'),(1,'a:b:c:',0,'tomcat1'),(2,':::',0,'tomcat1'),(0,':::::',0,'tomcat1'),(1,':::',0,'tomcat1'),(0,'sdaf:sdfds:sdfs:',0,'tomcat1'),(0,':df:',0,'tomcat'),(0,'ravi:sdf:',0,'tomcat1'),(1,'::',0,'tomcat1'),(2,'ravi:101:',0,'tomcat'),(0,'ravi:raju:',0,NULL),(1,'ravi:raju:ram:',0,NULL),(2,':::',0,'tomcat'),(0,':::',0,'adf'),(1,':::',0,'tomcat');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
