package strategies;

public class UpiPaymentStrategy implements PaymentStrategy{

    private String mobileNumber;
    public UpiPaymentStrategy(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. "+ amount + " to "+ mobileNumber + " through UPI.");
    }

}
