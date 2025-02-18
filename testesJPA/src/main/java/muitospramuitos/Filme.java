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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double score;
	
	@ManyToMany
	@Cascade(CascadeType.PERSIST)
	@JoinTable(name = "atores_filmes",
			   joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), // renomeando id filme
			   inverseJoinColumns = @JoinColumn (name = "ator_id", referencedColumnName = "id") // renomeando id ator
	)
	
	private List<Ator> atores;
	
	public Filme() {
		atores = new ArrayList<Ator>();
	}
	
	public Filme(String name, Double score) {
		super();
		this.name = name;
		this.score = score;
		atores = new ArrayList<Ator>();
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(score, other.score);
	}
	
	

	@Override
	public String toString() {
		return "Filme [id=" + id + ", name=" + name + ", score=" + score + "]";
	}

	public void adicionarAtor(Ator ator) {
		if (!atores.contains(ator) ) {
			atores.add(ator);
			if(!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}	
	
	public void removerAtor (Ator ator) {
		if(atores.remove(ator)) {
			ator.getFilmes().remove(this);
		}
		
	}
	
	

}
