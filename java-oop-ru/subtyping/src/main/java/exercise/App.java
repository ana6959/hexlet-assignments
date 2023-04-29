package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static KeyValueStorage swapKeyValue(KeyValueStorage keyValue) {

        for (Map.Entry<String, String> entry: keyValue.toMap().entrySet()) {
            String tempValue = entry.getKey();
            String tempKey = entry.getValue();
            keyValue.unset(tempValue);
            keyValue.set(tempKey, tempValue);
        }

        return keyValue;

    }

}
// END
