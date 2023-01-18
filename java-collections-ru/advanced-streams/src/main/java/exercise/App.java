package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String data) {

        String[] resultSpl = data.split("\n");
        String result = Arrays.stream(resultSpl)
                .map(x -> x.replaceAll("\"", "").trim())
                .filter(x -> x.startsWith("environment="))
                .map(x -> x.replaceAll("environment=", ""))
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
        return result;
    }
}
//END
