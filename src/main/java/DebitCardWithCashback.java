// Класс DebitCardWithCashback, производный от DebitCard
public class DebitCardWithCashback extends DebitCard {
    private double cashbackRate;

    public DebitCardWithCashback(double initialBalance, double cashbackRate) {
        super(initialBalance);
        this.cashbackRate = cashbackRate;
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            double cashbackAmount = amount * this.cashbackRate;
            System.out.println("Cashback received: " + cashbackAmount);
            return true;
        }
        return false;
    }
}
