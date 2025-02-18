package composicaoModelagem3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		
		// --------------Dados do cliente: -----------------//
		System.out.println("Enter a cliente data: ");
		
		System.out.print("Name: ");
		String enterName = entrada.nextLine();

		System.out.print("Email: ");
		String enterEmail = entrada.nextLine();
		
		System.out.print("BirthDate: ");
		Date enterDate = sdf2.parse(entrada.nextLine());
		
		Client client = new Client(enterName, enterEmail, enterDate);
		
		// --------------Dados do PEDIDO: -----------------//
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus enterStatus = OrderStatus.valueOf(entrada.nextLine().toUpperCase());
		
		Order order = new Order(enterStatus, client);
		
		
		// --------------Dados do Produtos/Itens: -----------------//
		System.out.println("How many items to this order ?: ");
		int numberProducts = entrada.nextInt();
		entrada.nextLine();
		
		for(int i = 1; i <= numberProducts; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product Name: ");
			String productName = entrada.nextLine();
			
			System.out.print("Product Price: ");
			Double productPrice = entrada.nextDouble();
			entrada.nextLine();

			System.out.print("Quantity: ");
			int productQuantity = entrada.nextInt();
			entrada.nextLine();
			
			OrderItem orderItem = new OrderItem(productQuantity, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		Double totalPrice= 0.0;
		
		StringBuilder sb = new StringBuilder("Order Summary: \n");
		sb.append("Order moment: " + sdf.format(order.getMoment()) + "\n");
		sb.append("Order status: " + order.getStatus() + "\n");
		sb.append("Client: " + order.nomeCliente());
		sb.append(" (" + sdf.format(order.birthdayCliente())+ ") ");
		sb.append("- " + order.emailCliente() + "\n");
		sb.append("Order items: \n");
		
		for(OrderItem o: order.items) {
			sb.append(o.getProduct().getName() + ", " + o.getPrice() + ", Quantity: " + o.getQuantity() + ", Subtotal: " + o.subTotal() + "\n");
			totalPrice += o.subTotal(); 
		}
		
		sb.append("Total Price: " + totalPrice);
		
		System.out.println(sb);
		
		
		
		entrada.close();
	}
}
