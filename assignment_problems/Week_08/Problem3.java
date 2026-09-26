import java.util.*;

interface Room {
    double calculateBill(double units);
}

class SingleRoom implements Room {
    public double calculateBill(double units) {
        return units * 8;
    }
}

class SharedRoom implements Room {
    private int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    public double calculateBill(double units) {
        return (units * 6) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(double units) {
        return (units * 10) + 200;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom();
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;

                case "AC":
                    room = new ACRoom();
                    break;

                default:
                    continue;
            }

            double bill = room.calculateBill(units);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}