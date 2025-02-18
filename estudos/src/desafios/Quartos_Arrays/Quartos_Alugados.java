package desafios.Quartos_Arrays;

import java.util.Scanner;

public class Quartos_Alugados {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Rent[] quartos = new Rent[10];
		
		int quantidade;
		
		System.out.print("Quantos quartos alugados: ");
		quantidade = entrada.nextInt();
		
		for(int i = 0; i < quantidade; i++) {
			System.out.print("Qual é o número do quarto: ");
			int numeroQuarto = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Nome do aluno: ");
			String nomeAluno = entrada.nextLine();
			
			System.out.print("Email do aluno: ");
			String emailAluno = entrada.nextLine();
			
			quartos[numeroQuarto] = new Rent(nomeAluno, emailAluno);
		
		}
		
		for(int i = 0; i < 10; i++) {
			if(quartos[i] != null) {
				System.out.println("quarto: " + i + quartos[i]);
			}
		}
		entrada.close();
				
	
	
	}
	
}
