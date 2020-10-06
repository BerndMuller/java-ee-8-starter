package de.pdbm.business.messages.control;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.pdbm.business.messages.entity.Message;

@Startup
@Singleton
public class MessageInit {

	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void init() {
		em.persist(new Message("Hello world"));
	}
}
