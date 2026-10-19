
import java.util.*;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    protected double hours;

    static final double RATE = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * RATE;
    }

    boolean supportsSaver() {
        return false;
    }

    double calculateUnits(boolean saver) {
        double units = calculateUnits();

        if (saver && supportsSaver()) {
            units *= SaverMode.SAVER_FACTOR;
        }

        return units;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    System.out.println("Invalid appliance: " + type);
                    continue;
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = units * Appliance.RATE;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
