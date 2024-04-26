import java.util.List;

// Абстрактный класс BankCard
public abstract class BankCard {
    private double balance;

    public BankCard(double initialBalance) {
        this.balance = initialBalance;
    }

    public void topUp(double amount) {
        this.balance += amount;
    }

    public boolean pay(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public abstract List<String> getAllAvailableFunds();
}