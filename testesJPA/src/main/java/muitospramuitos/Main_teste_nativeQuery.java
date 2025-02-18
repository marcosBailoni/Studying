package muitospramuitos;

import infra.DAO;

public class Main_teste_nativeQuery {
	
	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		
		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");
		
		System.out.println(nota.getMedia());

		dao.fechar();
	}

}
