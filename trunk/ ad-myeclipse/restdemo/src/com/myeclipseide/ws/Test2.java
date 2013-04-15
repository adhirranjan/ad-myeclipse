package com.myeclipseide.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Produces("application/json")
@Consumes("application/json")
@Path("path2")
public class Test2 {
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String m1() {
		return "{'name2':'m1 modified'}";
	}

	@GET
	@Path("m2")
	public String m2() {
		return "{'name2':' m2 modified 1234567890'}";
	}

	@GET
	@Path("m3/{id}")
	public String m3(@PathParam("id") String id,@QueryParam("name") String name) {
		return "{'name3':' m3 modified 1234567890'" + id +  name + "}";
	}
}
