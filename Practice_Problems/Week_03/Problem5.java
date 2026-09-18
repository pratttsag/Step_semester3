import java.util.Scanner;

public class Problem5 {

    static void checkArmstrong(int number) {

        int origNumber = number;
        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum = sum + digit * digit * digit;

            number = number / 10;
        }

        if (sum == origNumber) {
            System.out.println("Is the number " + origNumber
                    + " an Armstrong number? true");
        } else {
            System.out.println("Is the number " + origNumber
                    + " an Armstrong number? false");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        checkArmstrong(number);

        scanner.close();
    }
}