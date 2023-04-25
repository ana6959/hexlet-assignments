package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {

    public static List<String> buildApartmentsList(List<Home> apartments, int number) {

        return apartments.stream()
                .sorted(Comparator.comparingInt(house -> (int) house.getArea()))
                .limit(number)
                .map(Object::toString)
                .collect(Collectors.toList());

    }

}
// END
