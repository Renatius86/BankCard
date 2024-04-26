// Пример использования
public class App {
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard(5000);
        DebitCardWithCashback cashbackDebitCard = new DebitCardWithCashback(3000, 0.03); // 3% cashback rate
        CreditCard creditCard = new CreditCard(0, 10000);
        CreditCardWithBonusPoints bonusCreditCard = new CreditCardWithBonusPoints(0, 20000, 0.02); // 2% bonus points rate

        // Пополнение и оплата с дебетовой карты с кэшбэком
        debitCard.topUp(2000);
        System.out.println(String.join("\n", debitCard.getAllAvailableFunds()));

        cashbackDebitCard.topUp(1000);
        cashbackDebitCard.pay(500);
        System.out.println(String.join("\n", cashbackDebitCard.getAllAvailableFunds()));

        // Пополнение и оплата с кредитной карты с бонусными баллами
        creditCard.topUp(5000);
        System.out.println(String.join("\n", creditCard.getAllAvailableFunds()));

        bonusCreditCard.topUp(3000);
        bonusCreditCard.pay(2000);
        System.out.println(String.join("\n", bonusCreditCard.getAllAvailableFunds()));
    }
}
