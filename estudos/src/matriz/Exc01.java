package matriz;

import java.util.Scanner;

public class Exc01 {
	
	public static void main(String[] args) {
		
		int x;
		boolean existe = false;
		int posicaox;
		int posicaoy;
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite o valor de linhas: ");
		int m = entrada.nextInt();
		System.out.print("Digite o valor de colunas: ");
		int n = entrada.nextInt();
		entrada.nextLine();
		
		int[][] mat = new int[m][n];
		
		System.out.println();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("Digite o Número: ");
				mat[i][j] = entrada.nextInt();
				
			}
		}
		
		System.out.println();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("(" + mat[i][j] + ")");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.print("Digite um número para validar se  existe na matriz: ");
		x = entrada.nextInt();
		
		
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == x) {
					System.out.println("Existe em Position: " + i + "," + j + "");
					existe = true;
					posicaox = j;
					posicaoy = i;
					
					//Vizinho esquerda:
					if(posicaox - 1 >= 0) {
						System.out.println("Vizinho esquerdo: " + mat[posicaoy][posicaox - 1]);
					}
					//Vizinho direita:
					if(posicaox + 1 <= n -1) {
						System.out.println("Vizinho direita: " + mat[posicaoy][posicaox + 1]);
					}
					//Vizinho de cima: 
					if(posicaoy - 1 >= 0) {
						System.out.println("Vizinho de cima " + mat[posicaoy - 1][posicaox]);
					}
					//Vizinho de baixo:
					if(posicaoy + 1 <= m -1) {
						System.out.println("Vizinho de baixo: " + mat[posicaoy + 1][posicaox]);
					}
				} 
			}
			System.out.println();
		}
		
		if(existe == false) {
			System.out.println(); //Pular linha
			System.out.println("Number not found");			
		} 
		
		
		entrada.close();
	}	
	
	
}
