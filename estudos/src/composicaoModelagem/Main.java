package composicaoModelagem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner entrada = new Scanner(System.in);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("MM/yyyy");
			
		System.out.printf("Enter departament's name: ");
		String depName = entrada.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.printf("Name: ");
		String enterName = entrada.nextLine();
		
		System.out.printf("Level: ");
		String enterLevel = entrada.nextLine().toUpperCase();
		
		System.out.printf("Base Salary: ");
		Double enterBS = entrada.nextDouble();
		
		System.out.printf("How many contracts to this worker ? ");
		int numberContracts = entrada.nextInt();
		entrada.nextLine();
		
		Worker worker = new Worker(enterName, WorkerLevel.valueOf(enterLevel) , enterBS, depName);
		
		for (int i = 1; i <= numberContracts; i++) {
			System.out.println("Enter contract #" + i + "data: ");
			System.out.printf("Data (DD/MM/YYYY): ");
			String data = entrada.nextLine();
			System.out.printf("Valuer per hour: ");
			Double valorHora = entrada.nextDouble();
			entrada.nextLine();
			System.out.printf("Duration (hours): ");
			Integer duration = entrada.nextInt();
			entrada.nextLine();
			
			worker.addContract(new HourContract(formatter.parse(data), valorHora, duration));
		}
		System.out.println();
		System.out.printf("Enter a month and a year to calculate income (MM/YYYY): ");
		String data = entrada.nextLine();
		Calendar dataFormatada = Calendar.getInstance();
		Date provisorio  = formatter2.parse(data);
		dataFormatada.setTime(provisorio);
		
		Double total = worker.income(dataFormatada.get(Calendar.YEAR), dataFormatada.get(Calendar.MONTH));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.departmentName());
		System.out.println("Income for " + data + ": " + total);
		
		
		
		entrada.close();
	}
}
