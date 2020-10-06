package de.pdbm.business.messages.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessageResource {

	@Inject
	MessageService messageService;

	public MessageResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allMessages() {
		return Response.ok(messageService.getAllMessages()).build();
	}
	
}
