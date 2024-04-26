import java.util.Collections;
import java.util.List;

// Класс CreditCardWithBonusPoints, производный от CreditCard
public class CreditCardWithBonusPoints extends CreditCard {
    private double bonusPointsRate;
    private double bonusPoints;

    public CreditCardWithBonusPoints(double initialBalance, double creditLimit, double bonusPointsRate) {
        super(initialBalance, creditLimit);
        this.bonusPointsRate = bonusPointsRate;
        this.bonusPoints = 0;
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            this.bonusPoints += amount * this.bonusPointsRate; // Начисляем бонусные баллы при покупках
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAllAvailableFunds() {
        return Collections.singletonList("Available funds: Balance - " + getBalance() + ", Credit funds - " + getCreditFunds() + ", Bonus points - " + this.bonusPoints);
    }
}