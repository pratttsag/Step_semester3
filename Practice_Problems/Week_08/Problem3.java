import java.util.*;

interface Delivery {
    double calculateFee();
}

class StandardDelivery implements Delivery {
    private double weight;
    private double distance;

    StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {
    private double weight;
    private double distance;

    ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {
    private double weight;
    private double distance;
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    double weight1 = sc.nextDouble();
                    double distance1 = sc.nextDouble();
                    delivery = new StandardDelivery(weight1, distance1);
                    break;

                case "EXPRESS":
                    double weight2 = sc.nextDouble();
                    double distance2 = sc.nextDouble();
                    delivery = new ExpressDelivery(weight2, distance2);
                    break;

                case "INTERNATIONAL":
                    double weight3 = sc.nextDouble();
                    double distance3 = sc.nextDouble();
                    double customsFee = sc.nextDouble();
                    delivery = new InternationalDelivery(
                            weight3, distance3, customsFee);
                    break;

                default:
                    continue;
            }

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}