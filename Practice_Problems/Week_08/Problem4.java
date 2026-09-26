import java.util.*;

interface Question {
    double evaluate();
}

class MCQ implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    MCQ(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalse implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    TrueFalse(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    Essay(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {
        String[] keywords = correctAnswer.split(",");

        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            List<String> values = new ArrayList<>();

            java.util.regex.Matcher matcher =
                    java.util.regex.Pattern
                            .compile("\"([^\"]*)\"|(\\S+)")
                            .matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    values.add(matcher.group(1));
                } else {
                    values.add(matcher.group(2));
                }
            }

            String type = values.get(0);
            String correctAnswer;
            String studentAnswer;
            double points;

            Question question;

            if (type.equals("MCQ")) {
                correctAnswer = values.get(2);
                studentAnswer = values.get(3);
                points = Double.parseDouble(values.get(4));

                question = new MCQ(correctAnswer, studentAnswer, points);

            } else if (type.equals("TF")) {
                correctAnswer = values.get(2);
                studentAnswer = values.get(3);
                points = Double.parseDouble(values.get(4));

                question = new TrueFalse(
                        correctAnswer, studentAnswer, points);

            } else {
                correctAnswer = values.get(2);
                studentAnswer = values.get(3);
                points = Double.parseDouble(values.get(4));

                question = new Essay(
                        correctAnswer, studentAnswer, points);
            }

            double score = question.evaluate();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}