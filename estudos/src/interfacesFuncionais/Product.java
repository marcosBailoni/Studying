package interfacesFuncionais;

public class Product {
	
	private String nome;
	private Double price;
	
	public Product(String nome, double price) {
		this.nome = nome;
		this.price = price;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product [nome = %s, price = %.2f]", nome, price);
	}

	
	
	
	
	

}
