
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
@Path("song")
public class Song {
	@GET
	@Path("fav/{user_id}")
	public String getFavorites(@PathParam("user_id") String user_id) {
		return SongBllc.getFavorites(user_id);
	}
	
	@GET
	@Path("updates/{user_id}")
	public String getSongUpdates(@PathParam("user_id") String user_id) {		
		return SongBllc.getSongUpdates(user_id);
	}
}
