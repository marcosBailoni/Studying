package muitospramuitos;

import infra.DAO;

public class Main_Teste {

	public static void main(String[] args) {
		
		Ator ator1 = new Ator("Pedro");
		Ator ator2 = new Ator("Luan");
		
		Filme filme1 = new Filme("Harry Potter", 8.0);
		Filme filme2 = new Filme("Segredo dos Anéis", 9.0);
		
		filme1.adicionarAtor(ator1);
		filme1.adicionarAtor(ator2);
		
		filme2.adicionarAtor(ator2);
		
		DAO<Object> dao = new DAO<Object>();
		
		dao.inserirAtomico(filme1);
		
		
		
	}
}
