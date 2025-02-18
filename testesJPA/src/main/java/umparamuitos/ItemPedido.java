package umparamuitos;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@Cascade(CascadeType.PERSIST)
	private Pedido pedido;

	@ManyToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Produto2 produto;

	@Column(nullable = false)
	private int quantidade; 
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private Double totalPrice;
	
	
	@Column(nullable = false)
	private String prodName;
	
	ItemPedido(){
	}

	public ItemPedido(Pedido pedido, Produto2 produto, int quantidade) {
		super();
		setPedido(pedido);
		setProduto(produto);
		setQuantidade(quantidade);
		setPrice(produto.getPrice());
		totalPrice = quantidade * price;
		prodName = produto.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto2 getProduto() {
		return produto;
	}

	public void setProduto(Produto2 produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	
	
	
	
	
}
