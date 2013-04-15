DROP PROCEDURE IF EXISTS `pr_regUser`;

DELIMITER $$
CREATE PROCEDURE `pr_regUser`(p_name varchar(45),p_email varchar(45),p_pwd varchar(45),OUT p_out_error varchar(100))
BEGIN
	DECLARE _count INT;
	SELECT count(1) INTO _count FROM users WHERE email=p_email;
	IF _count > 0 THEN
		SET p_out_error = 'Already registered.';
	ELSE
		INSERT INTO users(username,email,pwd) VALUES(p_name,p_email,p_pwd);			
	END If;	
END$$

DELIMITER ;

###############################
/*
set @out_error = '';
call pr_regUser('kmll', 'k@k.com', 'kpwd', @out_error);
select @out_error

*/