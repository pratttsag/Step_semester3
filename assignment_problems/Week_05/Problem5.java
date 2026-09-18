import java.util.Arrays;

public class Problem5 implements Comparable<Problem5> {

    // Private fields for encapsulation
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Problem5(String name, int matchesPlayed,
                    double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded method 1:
    // Experience-only rule
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Overloaded method 2:
    // Matches + fitness rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Compare players by fantasy points.
    // Here battingAverage is used as the ranking score.
    @Override
    public int compareTo(Problem5 other) {

        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Problem5[] players) {

        // Temporary array for draftable players
        Problem5[] draftable = new Problem5[players.length];

        int count = 0;

        // Find draftable players
        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed,
                                   players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Create an array containing only draftable players
        Problem5[] result = new Problem5[count];

        for (int i = 0; i < count; i++) {
            result[i] = draftable[i];
        }

        // Sort using compareTo()
        Arrays.sort(result);

        // Build output
        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output + (i + 1) + ". " + result[i].name;

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Problem5[] players = {
            new Problem5("Virat", 15, 48.0, false),
            new Problem5("Rahul", 7, 55.0, false),
            new Problem5("Sameer", 3, 60.0, false),
            new Problem5("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);

        System.out.println(result);
    }
}