
pr_mark_lovesong (user_id, song_id)
love
----------------

select * from love

DROP PROCEDURE IF EXISTS `pr_mark_lovesong`;

DELIMITER $$
CREATE PROCEDURE `pr_mark_lovesong`(p_user_id int,p_song_id int,OUT p_out_error varchar(100))
BEGIN
	DECLARE _countuser INT default 0;
	DECLARE _countsong INT default 0;
	SELECT count(1) INTO _countuser FROM users WHERE userid=p_user_id;
	SELECT count(1) INTO _countsong FROM songs WHERE userid=p_user_id and song_id =p_out_error ;
	IF _countuser = 0 THEN
		SET p_out_error = 'user not found.';
	ELSEIF _countsong = 0 THEN 
		SET p_out_error = 'song not found.';
	ELSE	
		insert into love(user_id_fk,song_id_fk)	values(p_user_id,p_song_id);
	END If;	

END$$

DELIMITER ;