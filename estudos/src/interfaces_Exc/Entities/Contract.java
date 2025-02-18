package interfaces_Exc.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contract {
	
	private Integer number;
	private LocalDate date;	
	private Double totalValue;
	
	private ArrayList<Installment> installments = new ArrayList<Installment>();
	

	public Contract(Integer number, LocalDate entradaData, Double totalValue) {
		this.number = number;
		this.date = entradaData;
		this.totalValue = totalValue;
	}
	
	
	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	

	public ArrayList<Installment> getInstallments() {
		return installments;
	}


	
	public void installmentsAdd (Installment installment) {
		installments.add(installment);
	}
	 
	public void installmentsRemove (Installment installment) {
		if (installments.contains(installment)) {
			installments.remove(installment);
		}
	}
}
