package polimorfismoHerança3;

public class PessoaFisica extends Pessoa{

	private Double gastosComSaude;
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	//gets --- sets:
	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	
	
	
	//method:
	@Override
	public Double calcularImposto() {
		Double imposto = 0.0;
		
		if(getRendaAnual() < 20000) {
			imposto = getRendaAnual() * 0.15;
		} else {
			imposto = getRendaAnual() * 0.25;
		}
		
		if(gastosComSaude > 0) {
			imposto = imposto - (gastosComSaude/2);
		}
		return imposto;
	}
	
	
	
	
}

