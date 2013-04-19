DROP PROCEDURE IF EXISTS `pr_getFavorites`;

DELIMITER $$
CREATE PROCEDURE `pr_getFavorites`(p_user_id int,OUT p_out_error varchar(100))
BEGIN
	DECLARE _count INT Default 0;	
	SELECT count(1) INTO _count  FROM favorites WHERE user_id_fk = p_user_id;
	IF _count = 0 THEN
		SET p_out_error = 'Record not found.';
	ELSE
		select  b.user_id_fk,b.song_url, coalesce(b.description,'') description,b.image_url,b.ts 
		from favorites a inner join songs b 				
				on  a.song_id_fk=b.song_id 
		where a.user_id_fk = p_user_id;
	END If;	
END$$

DELIMITER ;
###############################
 /*
set @pout  = '';
set  @out_user_id = 0;
call pr_getFavorites(1, @pout);
 
	select @pout;
 
 */