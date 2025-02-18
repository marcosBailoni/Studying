package interfaces_Exc.Services;

public interface OnlinePaymentService {

	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer month);
	
}
