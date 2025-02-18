package exercicios_Vetores;

public class Exc2 {

//	Crie dois vetores de 5 posições cada. 
//	Some os elementos de mesma posição dos 
//	dois vetores 	e armazene o resultado 
//	em um terceiro vetor. Imprima o vetor resultante.
	
	public static void main(String[] args) {
		int index = 0;
		int[] numerosImpares = new int[5];
		int[] numerosPares = new int[5];
		
		int[] numerosSomados = new int[5];
		
//		Inclusão numeros impares
		for(int i = 0; i < numerosImpares.length * 2; i++) {
			if(i % 2 == 1) {
				numerosImpares[index] = i;
				index++;
			}			
		}
		
//		Inclusão numeros pares
		index = 0;
		for(int i = 0; i < numerosPares.length * 2; i++) {
			if(i % 2 == 0) {
				numerosPares[index] = i;
				index++;
			}			
		}
		
		for(int i = 0; i < numerosSomados.length; i++) {
			numerosSomados[i] = numerosImpares[i] + numerosPares[i];
		}
		
		for (int nums : numerosImpares) {
			System.out.println("Numeros impares: " + nums);
		}
		
		for (int nums : numerosPares) {
			System.out.println("Numeros Pares: " + nums);
		}
		
		
		
		for (int nums : numerosSomados) {
			System.out.println("Numeros Somados: " + nums);
		}
		
		
	}
}
