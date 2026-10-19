
import java.util.*;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    protected double km;
    static final double MIN_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateFare();

    double applyMinimumFare() {
        return Math.max(MIN_FARE, calculateFare());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return km * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return km * 14;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    @Override
    double calculateFare() {
        return km * 18;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    System.out.println("Invalid cab type: " + type);
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.applyMinimumFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
