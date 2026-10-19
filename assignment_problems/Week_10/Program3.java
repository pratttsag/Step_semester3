
import java.util.Scanner;

public class Program3 {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];

        // Remove complete rotations
        k = k % n;

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}
