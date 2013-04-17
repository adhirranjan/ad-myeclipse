drop PROCEDURE  if exists pr_getSongUpdates;
DELIMITER $$
CREATE PROCEDURE pr_getSongUpdates(
	IN p_userid		int	
	, out p_out_error VARCHAR(255) 	
)
	TOP: BEGIN		
		set p_out_error = '';
		select * from songs where user_id_fk <> 2;
    END $$
 DELIMITER ;

###############################
 /*
set @pout  = '';
call pr_getSongUpdates(1, @pout);
select 1, @pout;
 */
set @pout  = '';
call pr_getSongUpdates(4, @pout);
select @pout  ;


