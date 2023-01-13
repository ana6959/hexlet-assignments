package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
//import java.util.Map.Entry;

// BEGIN
public class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> targets) {

        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> temprMap = new HashMap<>();

        for (Map<String, String> book: books) {

            for (Map.Entry<String, String> bookSet: book.entrySet()) {

                for (Map.Entry<String, String> target: targets.entrySet()) {

                    if (bookSet.equals(target)) {
                        temprMap.put(target.getKey(), target.getValue());
                    }

                }

                if (temprMap.equals(targets)) {
                    if (!result.contains(book)) {
                        result.add(book);
                    }
                }

            }
            temprMap.clear();
        }

        return result;
    }
}
//END
