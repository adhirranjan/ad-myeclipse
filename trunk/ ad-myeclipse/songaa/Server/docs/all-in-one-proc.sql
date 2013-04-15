drop PROCEDURE  if exists pr_temp_getUsers;
DELIMITER //
 CREATE PROCEDURE pr_temp_getUsers(IN countryName VARCHAR(255)
	, out paramout varchar(100) #default 'trust'
)
	BEGIN
		DECLARE employee_is_too_young CONDITION FOR SQLSTATE '99001';
		DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			RESIGNAL;
		END;
#####
if countryName = 'tssipl' then
		SIGNAL employee_is_too_young ;
		#SET paramout='Employee must be 16 years or older';
		#UPDATE `Employee must be 16 years or older` SET x=1;

	end if;
#####
       SELECT * from users;
	 set paramout  = 'tssipl' ;
	# RESIGNAL;
    END //
 DELIMITER ;

#DECLARE @pout varchar(100) ;
set @pout  = '';
call pr_temp_getUsers('tssipl', @pout  );
select @pout ;