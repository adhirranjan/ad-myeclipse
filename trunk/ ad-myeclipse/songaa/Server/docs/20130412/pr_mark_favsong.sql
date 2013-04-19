DROP PROCEDURE IF EXISTS `pr_mark_favsong`;

DELIMITER $$
CREATE PROCEDURE `pr_mark_favsong`(p_user_id int,p_song_id int,OUT p_out_error varchar(100))
BEGIN
	DECLARE _countuser INT default 0;
	DECLARE _countsong INT default 0;
	SELECT count(1) INTO _countuser FROM users WHERE user_id=p_user_id;
	SELECT count(1) INTO _countsong FROM songs WHERE user_id_fk=p_user_id and song_id =p_song_id ;
	IF _countuser = 0 THEN
		SET p_out_error = 'user not found.';
	ELSEIF _countsong = 0 THEN 
		SET p_out_error = 'song not found.';
	ELSE	
		insert into favorite(user_id_fk,song_id_fk)	values(p_user_id,p_song_id);
	END If;	

END$$

DELIMITER ;
