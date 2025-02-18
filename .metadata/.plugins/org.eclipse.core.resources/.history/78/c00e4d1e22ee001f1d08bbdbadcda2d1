package infra;

import java.util.List;

import entities.Contato;
import exceptions.PersonalizedExcepetion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
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

	public DAO openT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO sendT() {
		try {
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw e; // rollback
		}

		return this;
	}

	public DAO persist(Contato contato) {
		if (!contatoExists(contato)) {
			em.persist(contato);
		} else {
			throw new PersonalizedExcepetion("Contato já cadastrado");
		}
		return this;
	}

	public DAO atomicPersist(Contato contato) {
		return this.openT().persist(contato).sendT();
	}

	public Contato findById(int id) {
		Contato contato = em.find(Contato.class, id);
		if (contato == null) {
			throw new PersonalizedExcepetion("Contato não existe");
		} else {
			return contato;
		}
	}

	public List<Contato> findByName(String name) {
		String jpql = "SELECT c FROM Contato c WHERE c.nome LIKE :name";
		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	public List<Contato> findAll() {
		String jpql = "SELECT c FROM Contato c";
		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		return query.getResultList();
	}

	public void closeDAO() {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	public Contato findByNumber(Contato contato) {
		String jpql = "SELECT c FROM Contato c WHERE c.number = :number";
		TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
		query.setParameter("number", contato.getNumber());

		try {
			return query.getSingleResult(); // Retorna o único contato encontrado
		} catch (NoResultException e) {
			throw new PersonalizedExcepetion("Contato não cadastrado");
		}
	}

	public boolean contatoExists(Contato contato) {
		try {
			String jpql = "SELECT c FROM Contato c WHERE c.number = :number";
			TypedQuery<Contato> query = em.createQuery(jpql, Contato.class);
			query.setParameter("number", contato.getNumber());

			return query.getSingleResult() != null;
		} catch (NoResultException e) {
			return false; // Nenhum contato encontrado, então não existe
		} catch (Exception e) {
			System.err.println("Erro ao verificar se o contato existe: " + e.getMessage());
			return false; // Falha inesperada
		}
	}

	public void changeContato(int id, String newName, Long newNumber) {
		try {
			Contato c = em.find(Contato.class, id);

			if (c != null) {

				c.setName(newName);
				c.setNumber(newNumber);
				em.merge(c);
				em.getTransaction().commit();
			} else {
				throw new PersonalizedExcepetion("Contato não encontrado");
			}

		} catch (Exception e2) {

			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.err.println("Erro inesperado ao alterar o contato: " + e2.getMessage());
			throw new PersonalizedExcepetion("Erro inesperado ao alterar o contato");
		}
	}

}
