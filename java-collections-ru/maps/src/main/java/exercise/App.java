package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {

        String[] words = sentence.split(" ");
        Map<String, Integer> wordsSet = new HashMap<>();

        if (!sentence.equals("")) {

            var count = 0;

            for (String word : words) {
                count = wordsSet.getOrDefault(word, 0);
                count++;
                wordsSet.put(word, count);
            }

        }

        return wordsSet;

    }

    public static String toString(Map<String, Integer> wordsSet) {

        StringBuilder result = new StringBuilder("{");

        if (wordsSet.isEmpty()) {
            result = new StringBuilder("{}");
            return result.toString();
        }

        for (Map.Entry<String, Integer> word: wordsSet.entrySet()) {
            result.append("\n  ").append(word.getKey()).append(": ").append(word.getValue());
        }

        result.append("\n}");
        return result.toString();
    }
}
//END
