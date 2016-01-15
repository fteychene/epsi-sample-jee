package fte.tests.jeerestcdi.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
public class GreetController {
	
	@Inject
	private GreetService service;
	
	@Path("/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String greet(@PathParam("name") String name) {
		return service.greet(name);
	}

	public GreetService getService() {
		return service;
	}

	public void setService(GreetService service) {
		this.service = service;
	}

}
