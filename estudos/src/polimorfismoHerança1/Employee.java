package polimorfismoHerança1;

public class Employee {

	private String name;
	private Integer hours;
	private Double valuePerHour;
	
	// Constructors: -------------
	
	public Employee() {		
	}
	
	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}
	
	
	// --------------- GETS & SETS _----------------//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	// ----------methods; ---------
	public double payment() {
		return valuePerHour * hours;
	}
	
}
