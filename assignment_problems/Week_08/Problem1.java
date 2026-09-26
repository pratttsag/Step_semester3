import java.util.*;

interface Customer {
    double calculateAmount(double amount);
}

class Student implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double calculateAmount(double amount) {
        return amount + 10;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Customer> customers = new HashMap<>();
        customers.put("STUDENT", new Student());
        customers.put("STAFF", new Staff());
        customers.put("GUEST", new Guest());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = customers.get(type);
            double finalAmount = customer.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}