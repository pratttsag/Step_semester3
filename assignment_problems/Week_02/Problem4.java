public class Problem4 {

    static String normalizeCode(String raw) {

        String code = raw.trim();

        String publisher = code.substring(0, 3).toUpperCase();
        String rest = code.substring(3);

        return publisher + rest;
    }

    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        return "[" + code.substring(0, 3) + "] YEAR: "
                + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}