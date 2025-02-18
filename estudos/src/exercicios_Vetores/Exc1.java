package exercicios_Vetores;

public class Exc1 {
	
//	Criação e Impressão de um Vetor
//	Descrição: Crie um vetor de inteiros com 10 posições, inicialize-o com valores de 1 a 10 e imprima cada valor.
//	Dica: Use um laço for para percorrer o vetor e imprimir os valores.
	
	public static void main(String[] args) {
		
		int[] numeros = new int[10];
		int start = 1;
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = start;
			System.out.println("Numero " +  start  + " adicionado");
			start++;
		}
		
		for(int i = 0; i <= numeros.length; i++ ) {
			System.out.println("Print do array, indice: ["+ i +"] = " + numeros[i]);
		}
	}

}
