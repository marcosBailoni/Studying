package umparamuitos;

import infra.DAO;

public class MainTesteInsercao {
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido();
		Produto2 produto = new Produto2("Computador", 2000.0);		
		ItemPedido itemPedido = new ItemPedido(pedido, produto, 10);
		
		DAO<ItemPedido> dao = new DAO<>();
		
		dao.inserirAtomico(itemPedido).fechar();		
		
	}

}
