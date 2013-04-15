package com.myeclipseide.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces("application/json")
@Consumes("application/json")
@Path("path1")
public class Test1 {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String m1() {
		return "{'name':'name goes here'}";
	}
}