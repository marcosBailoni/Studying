package desafios.Quartos_Arrays;

public class Rent {
	
	private String nome;
	private String email;
	
	//Construtores:
	public Rent() {
		
	}
	
	public Rent(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
//	------------ / -----------
//	Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return ", nome = " + nome + ", email = " + email;
	}

//	------------ / -----------



}
