#users

insert  into `users`(`user_id`,`email`,`pwd`,`username`,`ts`) values 
(1,'a@a.com','a','komal','2013-04-13 17:49:08')
,(2,'b@b.com','b','adhir','2013-04-13 17:49:11')
,(3,'c@c.com','c','navnit','2013-04-13 17:49:25')
,(4,'d@d.com','d','sanjay','2013-04-13 17:49:37')
,(5,'e@e.com','e','lokesh','2013-04-13 17:50:03')
,(6,'f@f.com','f','ashish','2013-04-13 17:50:15')
,(7,'g@g.com','g','prashant','2013-04-13 17:50:28');

#songs

insert  into `songs`(`song_id`,`song_url`,`description`,`image_url`,`user_id_fk`,`ts`) values 
(1,'Death Grips - Blackjack.mp3',NULL,'1.jpg',1,'2013-04-13 18:01:25')
,(2,'Dillon - Thirteen Thirtyfive.mp3',NULL,'2.jpg',1,'2013-04-13 18:01:33')
,(3,'Cloud Nothings - Stay Useless.mp3Cloud Nothings - Stay Useless.mp3',NULL,'3.jpg',1,'2013-04-13 18:01:38')
,(4,'Bon Iver - Calgary.mp3',NULL,'4.jpg',2,'2013-04-13 18:02:21')
,(5,'Death Grips - I\'ve Seen Footage.mp3',NULL,'5.jpg',4,'2013-04-13 18:01:45')
,(6,'Death Grips - The Fever (Aye Aye).mp3',NULL,'1.jpg',3,'2013-04-13 18:01:55')
,(7,'Death Grips - Get Got.mp3',NULL,'1.jpg',3,'2013-04-13 18:01:59')
,(8,'Best Coast - The Only Place.mp3',NULL,'1.jpg',3,'2013-04-13 18:02:03')
,(9,'The Vaccines - If You Wanna.mp3',NULL,'1.jpg',3,'2013-04-13 18:02:08')
,(10,NULL,NULL,NULL,3,'2013-04-13 17:56:52');

#
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (1,1,1,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (2,1,2,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (3,1,3,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (4,1,4,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (5,1,5,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (6,1,6,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (7,1,7,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (8,1,8,'2013-04-13 18:15:13');
insert  into `favorites`(`favorite_id`,`user_id_fk`,`song_id_fk`,`ts`) values (9,1,9,'2013-04-13 18:15:13');
#
insert  into `loves`(`love_id`,`user_id_fk`,`song_id_fk`,`ts`) values (1,1,2,'2013-04-13 18:18:02');