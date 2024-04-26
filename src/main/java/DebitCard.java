import java.util.Collections;
import java.util.List;

// Класс DebitCard, производный от BankCard
public class DebitCard extends BankCard {
    private double bonusPoints;

    public DebitCard(double initialBalance) {
        super(initialBalance);
        this.bonusPoints = 0;
    }

    public void topUp(double amount) {
        super.topUp(amount);
        this.bonusPoints += amount * 0.005; // Начисляем бонусы за пополнение
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            this.bonusPoints += amount * 0.01; // Начисляем бонусы за покупки
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAllAvailableFunds() {
        return Collections.singletonList("Available balance: " + getBalance() + ", Bonus points: " + this.bonusPoints);
    }
}