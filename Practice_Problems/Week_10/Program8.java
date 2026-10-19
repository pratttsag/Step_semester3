
import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int marks = sc.nextInt();
            char grade;

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks");
                continue;
            }

            if (marks >= 90) {
                grade = 'A';
            } else if (marks >= 75) {
                grade = 'B';
            } else if (marks >= 60) {
                grade = 'C';
            } else if (marks >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Grade " + grade);
        }

        sc.close();
    }
}
