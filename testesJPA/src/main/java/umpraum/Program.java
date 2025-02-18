package umpraum;

import java.util.List;

import infra.DAO;

public class Program {

	public static void main(String[] args) {
		
//		Assento assento = new Assento("19C");
//		Cliente cliente = new Cliente("Lucas", assento);
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
//		dao.abrirT()
//			.incluir(assento) // Com o cascade no onetoone, não precisa desse persist ;
//			.incluir(cliente)
//			.fecharT()
//			.fechar();
	
		
		
		List<Cliente> lista = dao.obterTodos();
		
		for (Cliente cliente2 : lista) {
			System.out.println(cliente2);
		}
		
		
		
		dao.fechar();
	}
	
		
}
