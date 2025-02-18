package polimorfismoHerança3;

public class PessoaJuridica extends Pessoa{

	private Integer numeroDeFuncionarios;

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// gets- sets
	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	// methods:
	
	@Override
	public Double calcularImposto() {
		Double imposto = 0.0;
		if(numeroDeFuncionarios > 10) {
			imposto = getRendaAnual() * 0.14;
		} else {
			imposto = getRendaAnual() * 0.16;
		}	
		
		return imposto;
	}
	
	
	
	
}
