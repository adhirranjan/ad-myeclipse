drop PROCEDURE  if exists pr_getSongUpdates;
DELIMITER $$
CREATE PROCEDURE pr_getSongUpdates(
	IN p_userid		int	
	, out p_out_error VARCHAR(255) 	
)
	TOP: BEGIN		
		#song_url, image_url, user name, song desc, time stamp
		select s.song_url, u.username, coalesce(s.description, '') description, coalesce(s.image_url,'') image_url
			,CASE
				WHEN s.ts between date_sub(now(), INTERVAL 60 minute) and now() THEN concat(minute(TIMEDIFF(now(), s.ts)), ' minutes ago')
				WHEN datediff(now(), s.ts) = 1 THEN 'Yesterday'
				WHEN s.ts between date_sub(now(), INTERVAL 24 hour) and now() THEN concat(hour(TIMEDIFF(NOW(), s.ts)), ' hours ago')
				ELSE date_format(s.ts, '%a, %m/%d/%y')
				END 'ts'
		from songs  s
		inner join users u on u.user_id = s.user_id_fk
		where user_id_fk <> p_userid;
    END $$
 DELIMITER ;

###############################
 /*
set @pout  = '';
call pr_getSongUpdates(1, @pout);
select 1, @pout;
 */
set @pout  = '';
call pr_getSongUpdates(1, @pout);
#select @pout ;


