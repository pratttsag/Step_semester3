import java.time.LocalDate;
import java.util.*;

interface LibraryItem {
    LocalDate calculateDueDate(LocalDate currentDate);
}

class Book implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

class BorrowedItem {
    String type;
    String title;
    LibraryItem item;

    BorrowedItem(String type, String title, LibraryItem item) {
        this.type = type;
        this.title = title;
        this.item = item;
    }

    LocalDate getDueDate(LocalDate currentDate) {
        return item.calculateDueDate(currentDate);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, LibraryItem> items = new HashMap<>();
        items.put("BOOK", new Book());
        items.put("DVD", new DVD());
        items.put("MAGAZINE", new Magazine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String type;
            String title;

            int space = line.indexOf(' ');
            type = line.substring(0, space);
            title = line.substring(space + 1).trim();

            // Remove surrounding quotes
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = items.get(type);
            BorrowedItem borrowedItem = new BorrowedItem(type, title, item);

            LocalDate dueDate = borrowedItem.getDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}