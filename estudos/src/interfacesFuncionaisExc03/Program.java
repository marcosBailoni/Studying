package interfacesFuncionaisExc03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Employee> employeeList = new ArrayList<>();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = entrada.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){			
			String read = br.readLine();
			
			while (read != null) {				
				String[] vect = read.split(",");				
				employeeList.add(new Employee(vect[0], vect[1], Double.parseDouble(vect[2])));				
				read = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
		System.out.print("Enter salary: ");
		Double salary = entrada.nextDouble();
		
		List<String> emails = employeeList.stream()
				.filter(e -> e.getSalary() > salary)
				.map(e -> e.getEmail())
				.sorted((o1, o2) -> o1.toUpperCase().compareTo(o2.toUpperCase()))
				.toList();
		
		System.out.printf("Email of people whose salary is more than %.2f \n", salary);
		emails.forEach(System.out::println);
		
		double sumM = employeeList.stream()
				.filter(e -> e.getName().toUpperCase().startsWith("M"))
				.map(e -> e.getSalary())
				.reduce(0.0, (e1, e2) -> e1 + e2);						
				
		System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", sumM);
		
		
		entrada.close();
	}

}
