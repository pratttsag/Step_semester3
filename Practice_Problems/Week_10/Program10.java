
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class Program10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();

            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }

            Student student = new Student(name, marks);

            System.out.printf(
                "%s: Average %.1f, Grade %c%n",
                student.name.toUpperCase(),
                student.calculateAverage(),
                student.calculateGrade()
            );
        }

        sc.close();
    }
}
