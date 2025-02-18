package polimorfismoHerança3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("Enter the number of  tax payers: ");	
		int n = entrada.nextInt();
		entrada.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax Payer #" + i + " data: ");
			
			System.out.print("Individual or company (i/c) ?: ");
			char tipo = entrada.nextLine().toLowerCase().charAt(0);
			
			System.out.printf("Name: ");
			String name = entrada.nextLine();
			
			System.out.printf("Anual Income: ");
			Double rendaAnual = entrada.nextDouble();
			entrada.nextLine();
			
			if(tipo == 'i') {
				System.out.print("Health expenditures: ");
				Double gastosSaude = entrada.nextDouble();
				entrada.nextLine();				
				pessoas.add(new PessoaFisica(name, rendaAnual, gastosSaude));
				
			} else {
				System.out.print("Number of employees: ");
				Integer numeroFuncionarios = entrada.nextInt();
				entrada.nextLine();
				
				pessoas.add(new PessoaJuridica(name, rendaAnual, numeroFuncionarios));
			}		
			
		}
		
		System.out.println("\nTaxes Paid:");
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome() + ": $ " + String.format("%.2f", p.calcularImposto()));
		}
		
		
		
		entrada.close();
	}
}
