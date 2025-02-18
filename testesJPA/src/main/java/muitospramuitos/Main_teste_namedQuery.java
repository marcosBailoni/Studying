package muitospramuitos;

import java.util.List;

import infra.DAO;

public class Main_teste_namedQuery {
	
	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		
		List<Filme> filmes = dao.consultar("FindByNotaMaiorQue", "nota", 8.5);
		
		for (Filme filme : filmes) {
			System.out.println(filme.getName());
			System.out.println(filme.getAtores());
			System.out.println(filme.getScore());
		}
		
	}

}


// JPQL criada em orm.xml
// metodo criado em DAO pra implementar ela de forma genérica
