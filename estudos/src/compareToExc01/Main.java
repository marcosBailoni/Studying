package compareToExc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		String inputPath = "C:\\temp\\in.csv";
		
		List<Product> lista = new ArrayList<Product>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputPath))){
			String line = br.readLine();
			
			while(line != null) {
				String[] leituras = line.split(",");
				lista.add(new Product(leituras[0], Double.parseDouble(leituras[1])));
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for(Product p : lista) {
			System.out.println(p);
		}
		
//		Product maisCaro = Collections.max(lista);
		
//		Product maisCaro = ServiceCalcMax.max(lista);
		
		
		System.out.println();
		System.out.println("Imprimindo pelo Collections.max: ");
		System.out.println("Produto mais caro da lista é: " + Collections.max(lista).getName() + String.format("%.2f", Collections.max(lista).getPrice()));
		
		System.out.println();
		System.out.println("Imprimindo pelo ServiceCalcMax.max (classe criada manualmente): ");
		System.out.println("Produto mais caro da lista é: " + ServiceCalcMax.max(lista).getName() + String.format("%.2f", Collections.max(lista).getPrice()));
	}
}
