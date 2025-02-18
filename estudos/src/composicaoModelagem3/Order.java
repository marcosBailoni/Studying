package composicaoModelagem3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	
	List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order(){
	}

	public Order(OrderStatus status, Client client) {		
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public String nomeCliente() {
		return client.getName();
	}
	
	public Date birthdayCliente() {
		return client.getBirthDate();
	}
	
	public String emailCliente() {
		return client.getEmail();
	}
	
	public Double total() {
		Double sum = 0.0;
		for (OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}
		
}
