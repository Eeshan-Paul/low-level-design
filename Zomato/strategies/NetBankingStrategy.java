package strategies;

public class NetBankingStrategy implements PaymentStrategy {
    private String bankAccountNumber;
    public NetBankingStrategy(String bankAccountNumber)
    {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. "+ amount + " to "+ bankAccountNumber + " through NetBanking.");
    }
}
