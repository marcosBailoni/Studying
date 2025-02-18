package program;

import entities.Contato;
import infra.DAO;

public class Main {

	public static void main(String[] args) {
		
		Contato c1 = new Contato("Lucas Alves", 999999999L, "lucas@email.com");
		Contato c2 = new Contato("Pedro Lucas", 888888888L, "pedro@email.com");
		Contato c3 = new Contato("João Alves ", 777777777L, "joao@email.com");
		Contato c4 = new Contato("Joaquim Alcantara", 666666666L, "joaquim@email.com");
		
		DAO dao = new DAO();
		
		try {
			dao.atomicPersist(c1);
			dao.atomicPersist(c2);
			dao.atomicPersist(c3);
			dao.atomicPersist(c4);
			dao.atomicPersist(c4);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(dao.findAll());
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
		
		dao.closeDAO();
	}
}
