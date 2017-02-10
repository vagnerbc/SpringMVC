package br.com.contatos.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class JpaContatoDao implements IContatoDao{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void adiciona(Contato contato) {
		manager.persist(contato);
	}
	
	public List<Contato> getLista() {
		return manager.createQuery("select c from Contato c").getResultList();
	}
	
	public Contato getContato(long id){
		return manager.find(Contato.class, id);
	}
	
	@Transactional
	public void altera(Contato contato) {
		manager.merge(contato);
	}
	
	@Transactional
	public void remove(Contato contato) {
		manager.remove(contato);
	}
}
