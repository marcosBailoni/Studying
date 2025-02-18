package polimorfismoHerança2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner entrada = new Scanner(System.in);
		Product product;
		List<Product> products = new ArrayList<Product>();
		
		System.out.print("Enter the number of Products: ");
		int n = entrada.nextInt();
		entrada.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Product #%d data: \n", i);
			System.out.print("Common, user or imported ? (c/u/i): ");
			char type = entrada.next().toLowerCase().charAt(0);
			entrada.nextLine();
			
			System.out.print("Name: ");
			String prodName = entrada.nextLine();
			
			System.out.print("Price: ");
			Double prodPrice = entrada.nextDouble();
			entrada.nextLine();
			
			if(type == 'i') {
				System.out.print("Customs fee: ");
				Double prodCF = entrada.nextDouble();
				entrada.nextLine();
				product = new ImportedProduct(prodName, prodPrice, prodCF);
				
			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date prodMD = sdf.parse(entrada.nextLine());
				product = new UsedProduct(prodName, prodPrice, prodMD);
				
			} else {
				product = new Product(prodName, prodPrice);
			}
			
			products.add(product);
		}
		System.out.println("\nPRICE TAGS: ");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		
		entrada.close();
	}

}
