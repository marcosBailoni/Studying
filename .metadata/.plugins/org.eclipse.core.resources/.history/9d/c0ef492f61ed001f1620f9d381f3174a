package infra;

import java.util.List;

import entities.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DAO {
	
	private static EntityManagerFactory emf;
	private EntityManager em;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("agenda-jpa");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}	

	public DAO() {
		em = emf.createEntityManager();
	}
	
	public DAO openT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO sendT(){
		em.getTransaction().commit();
		return this;
	}
	
	
	public DAO persist(Contato contato){
		em.persist(contato);
		return this;
	}
	
	public DAO atomicPersist(Contato contato){
		return this.openT().persist(contato).sendT();
	}
	
	public Contato buscarPorId(int id){
		return(em.find(Contato.class, id));		
	}
	
	public List<Contato> findByName(String name){
		String jpql = "SELECT c FROM Contato c WHERE c.nome LIKE :name";
		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	
	public List<Contato> findAll(){
		String jpql = "SELECT c FROM Contato c";
		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		return query.getResultList();
	}
	
	public void closeDAO() {  
	    if (em != null && em.isOpen()) {  
	        em.close();  
	    }  
	}
	
}
