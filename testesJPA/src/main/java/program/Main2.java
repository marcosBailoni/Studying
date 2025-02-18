package program;

import java.util.List;

import entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main2 {
	// READ -- OBTER LIST DE USUARIOS - USANDO CONSULTA JPQL
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
//		String nome = "Marcos";
		String JPQL = "SELECT u FROM Usuario u";
//		String JPQL = "SELECT u FROM Usuario u WHERE u.name LIKE :nome"; // se quiser filtrar por nome
		
		TypedQuery<Usuario> query = em.createQuery(JPQL, Usuario.class);
//		query.setParameter("nome", "%" + nome + "%"); // Adiciona os curingas para busca parcial(nome = var)
		List<Usuario> users = query.getResultList();

		// outra forma de fazer também: mas sem os filtros
//		String JPQL = "SELECT u FROM Usuario u;
//		List<Usuario> users = em.createQuery(JPQL, Usuario.class).getResultList();

		for (Usuario usuario : users) {
			System.out.println(usuario);
		}

		em.close();
		emf.close();
	}
}
