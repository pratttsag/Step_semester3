public class Problem5 {

    static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        String reversedName = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversedName = reversedName + characters[i];
        }

        return reversedName;
    }

    public static void main(String[] args) {

        String customerName = "Sunil";

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}