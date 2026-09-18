import java.util.Scanner;

public class Problem4 {

    static void findGCD(int number1, int number2) {

        int originalNumber1 = number1;
        int originalNumber2 = number2;

        while (number2 != 0) {

            int remainder = number1 % number2;

            number1 = number2;
            number2 = remainder;
        }

        System.out.println("The GCD of " + originalNumber1
                + " and " + originalNumber2 + " is " + number1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();

        findGCD(number1, number2);

        scanner.close();
    }
}