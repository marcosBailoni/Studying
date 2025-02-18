package setExc02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		Set<Integer> cursoA = new HashSet<Integer>();
		Set<Integer> cursoB = new HashSet<Integer>();
		Set<Integer> cursoC = new HashSet<Integer>();

		System.out.print("How many students for course A ?: ");
		int totalA = entrada.nextInt();
		entrada.nextLine();

		for (int i = 1; i <= totalA; i++) {
			cursoA.add(entrada.nextInt());
			entrada.nextLine();
		}

		System.out.print("How many students for course B ?: ");
		int totalB = entrada.nextInt();
		entrada.nextLine();

		for (int i = 1; i <= totalB; i++) {
			cursoB.add(entrada.nextInt());
			entrada.nextLine();
		}
		System.out.print("How many students for course C ?: ");
		int totalC = entrada.nextInt();
		entrada.nextLine();
		
		for (int i = 1; i <= totalC; i++) {
			cursoC.add(entrada.nextInt());
			entrada.nextLine();
		}
		
		Set<Integer> cursoFinal = new HashSet<Integer>();
		
		cursoFinal.addAll(cursoA);
		cursoFinal.addAll(cursoB);
		cursoFinal.addAll(cursoC);
		
		System.out.println("Total students: " + cursoFinal.size());

		entrada.close();
	}
}
