package services;

public class PayPalService implements OnlinePaymentService{
	
	private static final double PAYMENT_FEE = 0.02;
	private static final double INTEREST = 0.01;

	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public double Interest(double amount, int months) {
		return amount * months * INTEREST;
	}

}
