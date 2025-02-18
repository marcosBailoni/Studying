package program;

import java.util.List;

import entities.Produto;
import infra.DAO;

public class Main3 {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<Produto>();
		
//		Produto p2 = new Produto("Limão", 15.5);
		
//		dao.inserirAtomico(p2);
		
		List<Produto> lista =  dao.obterTodos(1,1);
		
		for (Produto produto : lista) {
			System.out.println(produto);
		}
		
		dao.fechar();
	}
}
