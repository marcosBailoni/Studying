package interfaces_Exc.Program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import interfaces_Exc.Entities.Contract;
import interfaces_Exc.Entities.Installment;
import interfaces_Exc.Services.ContractService;
import interfaces_Exc.Services.PaypalService;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Contrato: ");
		
		System.out.print("Numero: ");
		int entradaNumero = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate entradaData = LocalDate.parse(entrada.nextLine(), formatter);
		
		
		System.out.print("Valor do contrato: ");
		Double entradaValor = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.print("Entre com o número de parcelas: ");
		int entradaParcelas = entrada.nextInt();
		
		Contract contrato = new Contract(entradaNumero, entradaData, entradaValor);
		
		ContractService contractService = new ContractService();
		
		contractService.processContract(contrato, entradaParcelas, new PaypalService());
		
		for(Installment i: contrato.getInstallments()) {
			System.out.println(i);
		}
		
		entrada.close();
	}
}
