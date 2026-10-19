
import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }

    void display() {
        System.out.printf(
            "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
            getClass().getSimpleName().toUpperCase(),
            calculateCharge(),
            calculateInsurance(),
            calculateTotal()
        );
    }
}

class Standard extends Parcel {
    Standard(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 80 + 15 * weight;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, declaredValue);
                    break;
                default:
                    System.out.println("Invalid parcel type: " + type);
                    continue;
            }

            parcel.display();
            grandTotal += parcel.calculateTotal();
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
