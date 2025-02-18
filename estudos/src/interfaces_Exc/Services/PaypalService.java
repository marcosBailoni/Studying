package interfaces_Exc.Services;

public class PaypalService implements OnlinePaymentService{
	
	

	@Override
	public Double paymentFee(Double amount) {
		
		return amount * 0.02;
//		return null;
	}

	@Override
	public Double interest(Double amount, Integer month) {
		return amount * ((1.0 * month) / 100.0);
//		return null;
	}
	
	
}
