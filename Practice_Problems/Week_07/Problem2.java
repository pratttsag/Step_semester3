class Scorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int answerCount;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    void recordAnswer(boolean correct) {
        if (answerCount < totalQuestions) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("Cannot record more answers.");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Problem2 {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}