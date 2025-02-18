package forDuplicado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exc01 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		List<Integer> numeros = new ArrayList<Integer>();

		System.out.print("Digite o tamanho da matriz: ");
		int tamanho = entrada.nextInt();

		for (int i = 0; i < tamanho * tamanho; i++) {
			System.out.print("Digite o próximo número: ");
			Integer numeroNovo = entrada.nextInt();
			numeros.add(numeroNovo);
		}

		int contador = 0;

		System.out.println("Matriz: ");
		for (int j = tamanho - 1; j < tamanho; j++) {
			for (int num : numeros) {
				System.out.print("[" + num + "]");
				contador++;
				if (contador == tamanho) {
					System.out.println();
					contador = 0;
				}
			}
		}
				
		int contador2 = 0;
		
		System.out.println("Diagonal principal: ");
		while(contador2 < tamanho * tamanho) {
			System.out.println(numeros.get(contador2));
			contador2 += tamanho + 1;
		}
		
		System.out.print("Numeros negativos: ");
		int contador3 = 0;
		while(contador3 < tamanho * tamanho) {
			for(int nums: numeros) {
				if(nums < 0) {
					System.out.print(nums + ", ");					
				}
			contador3++;
			}
		}
		

		entrada.close();
	}
}
