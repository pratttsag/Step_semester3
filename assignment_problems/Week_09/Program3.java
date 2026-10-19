
import java.util.*;

abstract class Student {
    protected String name;

    static final double TUITION_FEE = 40000;
    static final double BUS_FEE = 12000;
    static final double HOSTEL_FEE = 60000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getBusFee() {
        return usesBus() ? BUS_FEE : 0.0;
    }

    void display() {
        System.out.printf("%s: %.2f%n", name, calculateFee());
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE + getBusFee();
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE + HOSTEL_FEE;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE / 2 + getBusFee();
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    System.out.println("Invalid student type: " + type);
                    continue;
            }

            student.display();
            totalCollected += student.calculateFee();
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
