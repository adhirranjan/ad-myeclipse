DROP PROCEDURE IF EXISTS `pr_myfav`;

DELIMITER $$
CREATE PROCEDURE `pr_myfav`(p_userid int,OUT p_out_error varchar(100))
BEGIN
	DECLARE _count INT Default 0;
	SELECT count(1) INTO _count FROM favorite WHERE userid=p_userid;
	IF _count = 0 THEN
		SET p_out_error = 'Record not found.';
	ELSE
		select  b.user_id_fk,b.song_url,b.description,b.image_url,b.ts 
		from favorite a inner join songs b 
			on a.user_id_fk = b.user_id_fk
			and a.song_id_fk=b.song_id 
			where a.user_id_fk = p_userid;
	END If;	
END$$

DELIMITER ;