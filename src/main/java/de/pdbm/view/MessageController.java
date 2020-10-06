package de.pdbm.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import de.pdbm.business.messages.boundary.MessageService;
import de.pdbm.business.messages.entity.Message;

@Named
@RequestScoped
public class MessageController {
	
	@NotNull
	private String input;
	
	@Inject
	MessageService messageService;
	
	
	public MessageController() {
	}
	
	/**
	 * Saves input as Message text. 
	 */
	public void save() {
		messageService.save(new Message(input));
	}
	
	public Message getLastMessage() {
		return messageService.getLastMessage();
	}

	
	// Getter and Setter
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
}
