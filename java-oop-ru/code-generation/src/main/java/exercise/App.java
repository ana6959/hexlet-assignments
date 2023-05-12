package exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) {

        String json = car.serialize();
        try {
            Files.writeString(path, json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Car extract(Path path) {
        Car car;
        try {
            String json = Files.readString(path);
            car = Car.unserialize(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }


//    public static void main(String[] args) {
//        User owner = new User(1, "Ivan", "P", 25);
//        Car car = new Car(1, "bmv", "x5", "black", owner);
//        String jsonRepresentation = car.serialize();
//        System.out.println(jsonRepresentation);
//        Car instance = Car.unserialize(jsonRepresentation);
//        System.out.println(instance.toString());
//        System.out.println(instance.getBrand());
//        System.out.println(instance.getModel());
//    }
}
// END
