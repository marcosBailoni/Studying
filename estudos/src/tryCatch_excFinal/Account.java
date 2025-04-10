package tryCatch_excFinal;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	
	// --------------------- construtores---------------------
	
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	// --------------------- gets sets ---------------------
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
//	--------------------- methods ---------------------
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw (Double amount) throws ExceptionWithdraw1{
		if(amount > withdrawLimit) {
			throw new ExceptionWithdraw1("The amount exceeds withdraw limit");
		}
		
		if(amount > balance) {
			throw new ExceptionWithdraw1("Withdraw error: Not enough balance");
		}
		
		balance -= amount;
	}
	
}
