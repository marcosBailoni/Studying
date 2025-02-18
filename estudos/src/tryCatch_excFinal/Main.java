package tryCatch_excFinal;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Enter account data ");
		System.out.print("Number: ");
		Integer entradaNumber = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Holder: ");
		String entradaHolder = entrada.nextLine();
		
		System.out.print("Initial Balance: ");
		Double entradaBalance = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.print("Withdraw Limit: ");
		Double entradaLimit = entrada.nextDouble();
		entrada.nextLine();
		
		Account acc = new Account(entradaNumber, entradaHolder, entradaBalance, entradaLimit);
		
		try {
			System.out.print("\nEnter amout for withdraw: ");
			Double amount = entrada.nextDouble();
			acc.withdraw(amount);
			System.out.println("New balance: " + acc.getBalance());
		}		
		catch (ExceptionWithdraw1 e){
			System.out.println("Error in withdraw: " + e.getMessage());
		}
		
		entrada.close();
	}
}
