package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private final Map<String, String> keyValue;
    public InMemoryKV(final Map<String, String> keyValue) {
        this.keyValue = new HashMap<>(keyValue);
    }


    @Override
    public void set(String key, String value) {

        this.keyValue.put(key, value);
    }

    @Override
    public void unset(String key) {

        this.keyValue.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if ((this.keyValue.get(key) != null)) {
            return this.keyValue.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {

        return new HashMap<>(keyValue);
    }
}
// END
