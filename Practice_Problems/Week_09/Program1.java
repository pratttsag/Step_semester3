import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    String getShape() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class CIRCLE extends Plot {
    double radius;

    CIRCLE(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RECTANGLE extends Plot {
    double length, width;

    RECTANGLE(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class TRIANGLE extends Plot {
    double base, height;

    TRIANGLE(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot p;

            switch (shape) {
                case "CIRCLE":
                    p = new CIRCLE(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    p = new RECTANGLE(
                        owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    p = new TRIANGLE(
                        owner, sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid shape");
            }

            double area = p.calculateArea();

            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.getShape(), area);

            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}