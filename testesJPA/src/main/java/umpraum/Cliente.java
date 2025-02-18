 package umpraum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.PERSIST) //vai persistir automaticamente o assento ao persistir o cliente
	@JoinColumn(name = "assento_id_teste",unique = true)
	private Assento assento;

	Cliente(){
		
	}

	public Cliente(String name, Assento assento) {
		super();
		this.assento = assento;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Assento getAssento() {
		return assento;
	}
	
	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", assento=" + assento.getName() + "]";
	}
}
