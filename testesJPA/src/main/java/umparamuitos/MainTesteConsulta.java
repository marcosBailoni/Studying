package umparamuitos;

import infra.DAO;

public class MainTesteConsulta {
	
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido p1 = dao.findById(1);
		
		for (ItemPedido ip : p1.getList()) {
			System.out.println("Produto: " + ip.getProduto().getName() + 
					" - preço individual:  R$" + ip.getProduto().getPrice() + 
					" - quantidade: " + ip.getQuantidade() + 
					" - valor total: R$" + ip.getTotalPrice());
		}
	}

}
