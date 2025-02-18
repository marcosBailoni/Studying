package exercicios_Vetores;

public class Exc3 {

//	Criar dois vetores de números inteiros, 
//	verificar quais números são repetidos nos dois.
	
	public static void main(String[] args) {
		
		int[] vetor1 = new int[] {1, 3, 5, 6, 8, 10, 31, 21, 22};
		int[] vetor2 = new int[] {1, 6, 10, 12, 22, 31, 1};
		
		
		for(int i = 0; i < vetor1.length; i++) {
			for(int j = 0; j < vetor2.length; j++) {
				if(vetor1[i] == vetor2[j]) {
					System.out.println(vetor1[i]);
					break;
				}
			}
		}
	}
}
