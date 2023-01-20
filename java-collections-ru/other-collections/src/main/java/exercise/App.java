package exercise;

//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static java.util.stream.Stream.concat;

import java.util.Map;
import java.util.TreeMap;

// BEGIN
class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        Map<String, String> result = new TreeMap<>();

        if (data1.isEmpty()) {
            for (Map.Entry<String, Object> elm2: data2.entrySet()) {
                result.put(elm2.getKey(), "added");
            }
            return result;
        }

        if (data2.isEmpty()) {
            for (Map.Entry<String, Object> elm1: data1.entrySet()) {
                result.put(elm1.getKey(), "deleted");
            }
            return result;
        }

        for (Map.Entry<String, Object> elm1: data1.entrySet()) {

            for (Map.Entry<String, Object> elm2: data2.entrySet()) {

                if (elm1.getKey().equals(elm2.getKey())) {

                    if (elm1.getValue().equals(elm2.getValue())) {
                        result.put(elm1.getKey(), "unchanged");
                    } else {
                        result.put(elm1.getKey(), "changed");
                    }

                } else {
                    if (!data2.containsKey(elm1.getKey())) {
                        result.put(elm1.getKey(), "deleted");
                    }
                    if (!data1.containsKey(elm2.getKey())) {
                        result.put(elm2.getKey(), "added");
                    }

                }
            }
        }

        return result;
    }
}
//END
