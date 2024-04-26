import java.util.Collections;
import java.util.List;

// Класс CreditCard, производный от BankCard
public class CreditCard extends BankCard {
    private double creditLimit;
    private double creditFunds;

    public CreditCard(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
        this.creditFunds = creditLimit;
    }

    @Override
    public void topUp(double amount) {
        if (amount <= this.creditFunds) {
            this.creditFunds -= amount;
        } else {
            double remainingAmount = amount - this.creditFunds;
            this.creditFunds = 0;
            super.topUp(remainingAmount);
        }
    }

    @Override
    public boolean pay(double amount) {
        if (getBalance() >= amount) {
            super.pay(amount);
            return true;
        } else {
            double remainingAmount = amount - getBalance();
            if (remainingAmount <= this.creditFunds) {
                this.creditFunds -= remainingAmount;
                super.pay(getBalance());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getAllAvailableFunds() {
        return Collections.singletonList("Available funds: Balance - " + getBalance() + ", Credit funds - " + this.creditFunds);
    }

    public double getCreditFunds() {
        return creditFunds;
    }
}