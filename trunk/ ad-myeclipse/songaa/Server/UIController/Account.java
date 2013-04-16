
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
@Path("profile")
public class Account {
	@GET
	@Path("authenticate/{email}/{password}/{deviceId}")
	public String authenticate(@PathParam("email") String email,
			@PathParam("password") String password,
			@PathParam("deviceId") String deviceId) {
		return AccountBllc.authenticate(email, password, deviceId);
	}

	@GET
	@Path("register/{email}/{password}/{name}")
	public String register(@PathParam("email") String email,
			@PathParam("password") String password,
			@PathParam("name") String name) {
		return AccountBllc.register(email, password, name);
	}
}
