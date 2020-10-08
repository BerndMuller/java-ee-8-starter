package de.pdbm.business.messages.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class MessageResource {

	@Inject
	MessageService messageService;

	public MessageResource() {
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World!";
	}
	
	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response allMessages() {
		return Response.ok(messageService.getAllMessages()).build();
	}
	
}
