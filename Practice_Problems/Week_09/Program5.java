
import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50.0;

    abstract double calculateFare(double distance);

    double calculateTotal(double distance) {
        return calculateFare(distance) + BOOKING_FEE;
    }
}

class Bus extends Travel {
    @Override
    double calculateFare(double distance) {
        return distance * 2;
    }
}

class Train extends Travel {
    @Override
    double calculateFare(double distance) {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    @Override
    double calculateFare(double distance) {
        return 2500 + distance * 4;
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel t;

            switch (mode) {
                case "BUS":
                    t = new Bus();
                    break;

                case "TRAIN":
                    t = new Train();
                    break;

                case "FLIGHT":
                    t = new Flight();
                    break;

                default:
                    System.out.println("Invalid travel mode");
                    sc.close();
                    return;
            }

            double total = t.calculateTotal(distance);

            System.out.printf("%s: %.2f%n", mode, total);
        }

        sc.close();
    }
}
