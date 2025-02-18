package program;

import entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		//CRUD BÁSICO, 
		
//		Usuario u1 = new Usuario(null, "Ciclano2", "Ciclano2@gmail.com");
//		Usuario u2 = new Usuario(null, "fulano", "fulano@gmail.com");
//		Usuario u3 = new Usuario(null, "Pedro", "pedro@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin(); // Começar a transaction
//		em.persist(u1); ~~ Já inserido no BD; 
//		em.persist(u3);// ~~ Já inserido no BD;
		
		Usuario usuarioTeste = em.find(Usuario.class, 2); // atribuitr um orm para um obj
//		em.remove(usuarioTeste); // apagar o objeto 
		usuarioTeste.setName("Ciclano5");
		usuarioTeste.setEmail("ciclano5@gmail.com");
//		em.merge(usuarioTeste); // -> Irá enviar a alteração, commit faz automático para objetos monitorados
//		->   usar "em.detach" para desanexar, ai sim precisará do merge;
		
		em.getTransaction().commit(); // finalizar a transaction e subir as alterações
		System.out.println("Commit has finished!");
		
		
		em.close();
		emf.close();
	}
}
