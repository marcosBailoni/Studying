package polimorfismoHerança1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		
//		----------------------Descobrir quantidade de funcionários: ----------------------
		
		System.out.print("Enter the number of employees: ");
		int totalEmployess = entrada.nextInt();
		entrada.nextLine();
		
//		----------------------Adicionar cada funcionário em uma lista----------------------
		for (int i = 1; i <= totalEmployess; i++) {
			System.out.println("Employee #" + i + " data: ");
			
			System.out.print("Outsorced (y/n)?: "); 
			String Outsorced = entrada.nextLine();
			
			System.out.print("Name: ");
			String nameEntrada = entrada.nextLine();
			
			System.out.print("Hours: ");
			Integer hoursEntrada = entrada.nextInt();
			
			System.out.print("Value per hour: ");
			Double valueEntrada = entrada.nextDouble();
			entrada.nextLine();
			
			if(Outsorced.equals("n")) {
				Employee emp = new Employee(nameEntrada, hoursEntrada, valueEntrada);
				employees.add(emp);
			} else if (Outsorced.equals("y")){
				
				System.out.print("Additional charge: ");						
				Double addChargeEntrada = entrada.nextDouble();
				entrada.nextLine();
				
				Employee emp = new OutsourceEmployee(nameEntrada, hoursEntrada, valueEntrada, addChargeEntrada);
				employees.add(emp);
			}
		}		
		
		StringBuilder sb = new StringBuilder();
		
		for (Employee employee : employees) {
			sb.append("PAYMENTS: \n");
			sb.append("\n" + employee.getName() + " - $ ");
			sb.append(String.format("%.2f", employee.payment()));
			
		}
		
		System.out.println(sb);
		
		
		entrada.close();
	}
}
