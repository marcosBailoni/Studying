package umparamuitos;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Cascade(CascadeType.PERSIST)
	private int id; 
	
	@Column(nullable = false)
	private Date date;
	
	@OneToMany (mappedBy = "pedido")
	private List<ItemPedido> itens;	
	
	Pedido(){
		this(new Date());
	}

	Pedido(Date date){
		setDate(date);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public List<ItemPedido> getList(){
		return itens;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", date=" + date + ", itens=" + itens + "]";
	}
	
	
}
