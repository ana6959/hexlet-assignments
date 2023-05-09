package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class Tag {
    final String name;
    final Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }


    public String attributesToString() {

        Set<String> entries = new LinkedHashSet<>();
        entries.addAll(attributes.keySet());
        String result = entries.stream()
                .map(x -> x + "=" + "\"" + attributes.get(x) + "\"")
                .collect(Collectors.joining(" "));
        if (!attributes.isEmpty()) {
            result = " " + result;
        }
        return result;
    }

}
// END
