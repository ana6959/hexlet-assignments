package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private String body;
    private List<Tag> children;
    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (!children.isEmpty()) {
            str.append("<")
                    .append(name)
                    .append(attributesToString())
                    .append(">")
                    .append(body)
                    .append(childrenToString(children))
                    .append("</" + name + ">");
        } else {
            str.append("<")
                    .append(name)
                    .append(attributesToString())
                    .append(">")
                    .append(body)
                    .append("</" + name + ">");
        }
        return str.toString();

    }

    public String childrenToString(List<Tag> children) {
        StringBuilder str = new StringBuilder();
        for (Tag child: children) {
            str.append("<")
                    .append(child.getName())
                    .append(child.attributesToString())
                    .append(">");
        }
        return str.toString();

    }
}
// END
