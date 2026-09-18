import java.util.HashMap;

public class Problem5 {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Convert to lowercase and remove punctuation
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            // Check if the word is a stop word
            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            // Count only non-stop words
            if (!isStopWord) {
                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        // Sort by frequency in descending order
        frequency.entrySet()
                 .stream()
                 .sorted((a, b) ->
                     b.getValue().compareTo(a.getValue()))
                 .forEach(entry ->
                     System.out.println(
                         entry.getKey() + ": " + entry.getValue()
                     )
                 );
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}