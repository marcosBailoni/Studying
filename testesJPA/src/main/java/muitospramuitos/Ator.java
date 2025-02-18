package muitospramuitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "atores")
	@Cascade(CascadeType.PERSIST)
	private List<Filme> filmes;

	public Ator() {
		filmes = new ArrayList<Filme>();
	}
	
	public Ator(String name) {
		super();
		this.name = name;
		filmes = new ArrayList<Filme>();
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ator other = (Ator) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Ator [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
