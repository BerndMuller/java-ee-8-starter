package de.pdbm.business.messages.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.pdbm.business.messages.entity.Message;

@Stateless
public class MessageService {

	@PersistenceContext
	EntityManager em;
	
	
	public void save(Message message) {
		em.persist(message);
	}
	
	
	public List<Message> getAllMessages() {
		return em.createQuery("SELECT m FROM Message m ORDER by m.id", Message.class).getResultList();
	}
	
	
	public Message getLastMessage() {
		return em.createQuery("SELECT m FROM Message m WHERE m.id = (SELECT MAX(m.id) FROM Message m)", Message.class).getSingleResult();
	}
	
}
