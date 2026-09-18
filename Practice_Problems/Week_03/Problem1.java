import java.util.Scanner;

public class Problem1 {

    static void checkPrime(int number) {

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < number; i++) {

                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println("Is the number " + number
                + " a Prime number? " + isPrime);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        checkPrime(number);

        scanner.close();
    }
}