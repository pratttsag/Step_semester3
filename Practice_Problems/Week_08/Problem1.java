import java.util.*;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class Card implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount + (amount * 0.02);
    }
}

class Wallet implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount + (amount * 0.01);
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }
}

class Transaction {
    String type;
    double amount;
    PaymentMethod paymentMethod;

    Transaction(String type, double amount, PaymentMethod paymentMethod) {
        this.type = type;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    double getAdjustedAmount() {
        return paymentMethod.calculateAmount(amount);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, PaymentMethod> methods = new HashMap<>();
        methods.put("CARD", new Card());
        methods.put("WALLET", new Wallet());
        methods.put("BANKTRANSFER", new BankTransfer());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod method = methods.get(type);
            Transaction transaction = new Transaction(type, amount, method);

            double adjustedAmount = transaction.getAdjustedAmount();

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}