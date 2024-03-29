SET FOREIGN_KEY_CHECKS = 0;
#
#users 
drop table if exists users ;
CREATE TABLE  `users` (
	user_id INT NOT NULL primary key AUTO_INCREMENT ,
	email VARCHAR(45) NULL unique,
	pwd VARCHAR(45) NULL ,
	username VARCHAR(45) NULL,
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
#songs
drop table if exists songs;
CREATE TABLE  `songs` (
	song_id INT NOT NULL primary key AUTO_INCREMENT ,
	song_url VARCHAR(1000) NULL,
	description VARCHAR(1000) NULL,
	image_url VARCHAR(1000) NULL ,
	user_id_fk int, 
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	FOREIGN KEY (user_id_fk) REFERENCES users(user_id)
);
#favorite
drop table if exists favorite;
CREATE TABLE  `favorite` (
	favorite_id INT NOT NULL primary key AUTO_INCREMENT ,	
	user_id_fk int, 
	song_id_fk int, 
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	FOREIGN KEY (user_id_fk) REFERENCES users(user_id),
	FOREIGN KEY (song_id_fk) REFERENCES songs(song_id)
);
#love
drop table if exists love;
CREATE TABLE  `love` (
	love_id INT NOT NULL primary key AUTO_INCREMENT ,	
	user_id_fk int, 
	song_id_fk int, 
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	FOREIGN KEY (user_id_fk) REFERENCES users(user_id),
	FOREIGN KEY (song_id_fk) REFERENCES songs(song_id)
);
#comment
drop table if exists comment;
CREATE TABLE  `comment` (
	comment_id INT NOT NULL primary key AUTO_INCREMENT ,	
	comment VARCHAR(1000) NULL,
	user_id_fk int, 
	song_id_fk int, 
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	FOREIGN KEY (user_id_fk) REFERENCES users(user_id),
	FOREIGN KEY (song_id_fk) REFERENCES songs(song_id)
);
#
SET FOREIGN_KEY_CHECKS = 1;
#insert dummy record
insert into users(email, pwd, username) values('a@a.com','apwd', 'a');