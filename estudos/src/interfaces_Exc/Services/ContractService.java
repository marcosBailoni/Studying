package interfaces_Exc.Services;

import java.time.LocalDate;

import interfaces_Exc.Entities.Contract;
import interfaces_Exc.Entities.Installment;

public class ContractService {
	
	OnlinePaymentService ops;
	
	public void processContract(Contract contract, Integer months, OnlinePaymentService ops2) {
		this.ops = ops2;		
		
		for(int i = 1; i <= months; i++) {
			LocalDate newDate = contract.getDate().plusMonths(i);			
			Double amount = contract.getTotalValue() / months;
			
			amount += ops.interest(amount, i);
			amount += ops.paymentFee(amount);	
			
			Installment installment = new Installment(newDate, amount);
			
			contract.installmentsAdd(installment);
		}
		
	}
}
