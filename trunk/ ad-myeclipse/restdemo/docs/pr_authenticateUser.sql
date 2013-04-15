drop PROCEDURE  if exists pr_authenticateUser;
DELIMITER $$
CREATE PROCEDURE pr_authenticateUser(
	IN p_email VARCHAR(255)
	, IN p_pwd VARCHAR(255)
	, IN p_deviceid VARCHAR(255)
#	, out p_out_user_id int
	, out p_out_error VARCHAR(255) 	
)
	TOP: BEGIN		
		declare _uid int;
		set p_out_error = null;

		select  user_id, username
		from users where email = p_email and pwd = p_pwd;
		if FOUND_ROWS( ) =0 then
			set p_out_error = 'Invalid user or password.';
			LEAVE TOP;
		end if ;
		/*if coalesce(_uid , 0) = 0 then 
			set p_out_error = 'Invalid user or password.';
			LEAVE TOP;
		end if;
		
		set p_out_user_id  = _uid ;
*/
    END $$
 DELIMITER ;

###############################
 /*
set @pout  = '';
set  @out_user_id = 0;
call pr_authenticateUser('a@a.com', '1apwd','', @pout);
select @pout, @out_user_id;
 */