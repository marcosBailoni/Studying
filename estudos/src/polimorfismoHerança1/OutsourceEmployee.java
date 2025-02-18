package polimorfismoHerança1;

public class OutsourceEmployee extends Employee{

	private Double addtionalCharge;
	
//	----------------------------- CONSTRUCTOR ----------------------=--//
	public OutsourceEmployee() {
	}

	public OutsourceEmployee(String name, Integer hours, Double valuePerHour, Double addtionalCharge) {
		super(name, hours, valuePerHour);
		this.addtionalCharge = addtionalCharge;
	}

//	--------------------------- GETS & SETS -----------------------------//
	public Double getAddtionalCharge() {
		return addtionalCharge;
	}

	public void setAddtionalCharge(Double addtionalCharge) {
		this.addtionalCharge = addtionalCharge;
	}

	
//	-------------------------METHODS-------------------------//		
	
	@Override
	public double payment() {
		return super.payment() + (addtionalCharge += addtionalCharge * 0.1);
	}
	
	
}
	
	

