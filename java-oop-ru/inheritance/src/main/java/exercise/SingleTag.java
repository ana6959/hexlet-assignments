package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
            str.append("<")
                    .append(name)
                    .append(attributesToString())
                    .append(">");
            return str.toString();

    }
}
// END
