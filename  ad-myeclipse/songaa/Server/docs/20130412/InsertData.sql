/*
SQLyog Community Edition- MySQL GUI v6.02
Host - 5.5.29 : Database - test14
*********************************************************************
Server version : 5.5.29
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `test14`;

USE `test14`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Data for the table `comment` */

/*Data for the table `favorite` */

insert  into `favorite`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (1,1,2,'2013-04-13 18:15:13');

/*Data for the table `love` */

insert  into `love`(`love_id`,`user_id_fk`,`song_id_fk`,`ts`) values (1,1,2,'2013-04-13 18:18:02');

/*Data for the table `songs` */

insert  into `songs`(`song_id`,`song_url`,`description`,`image_url`,`user_id_fk`,`ts`) values (1,'Death Grips - Blackjack.mp3',NULL,'1.jpg',1,'2013-04-13 18:01:25'),(2,'Dillon - Thirteen Thirtyfive.mp3',NULL,'2.jpg',1,'2013-04-13 18:01:33'),(3,'Cloud Nothings - Stay Useless.mp3Cloud Nothings - Stay Useless.mp3',NULL,'3.jpg',1,'2013-04-13 18:01:38'),(4,'Bon Iver - Calgary.mp3',NULL,'4.jpg',2,'2013-04-13 18:02:21'),(5,'Death Grips - I\'ve Seen Footage.mp3',NULL,'5.jpg',4,'2013-04-13 18:01:45'),(6,'Death Grips - The Fever (Aye Aye).mp3',NULL,'1.jpg',3,'2013-04-13 18:01:55'),(7,'Death Grips - Get Got.mp3',NULL,'1.jpg',3,'2013-04-13 18:01:59'),(8,'Best Coast - The Only Place.mp3',NULL,'1.jpg',3,'2013-04-13 18:02:03'),(9,'The Vaccines - If You Wanna.mp3',NULL,'1.jpg',3,'2013-04-13 18:02:08'),(10,NULL,NULL,NULL,3,'2013-04-13 17:56:52');

/*Data for the table `users` */

insert  into `users`(`user_id`,`email`,`pwd`,`username`,`ts`) values (1,'komalbisen@rediffmail.com','a','komal','2013-04-13 17:49:08'),(2,'AdhirRanjan@gmail.com','a','adhir','2013-04-13 17:49:11'),(3,'navin@yahoo.com','a','navnit','2013-04-13 17:49:25'),(4,'sanjay@softtrust.com','a','sanjay','2013-04-13 17:49:37'),(5,'lokesh@rediffmail.com','a','lokesh','2013-04-13 17:50:03'),(6,'ashish@gmail.com','a','ashish','2013-04-13 17:50:15'),(7,'prashant@softtrust.com','a','prashant','2013-04-13 17:50:28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
