class AttendanceSheet {
    private String[] students;
    private int presentCount;

    AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    void markPresent(String name) {

        // Check if student is already present
        if (isPresent(name)) {
            return;
        }

        // Add student
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Problem5 {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());

        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}