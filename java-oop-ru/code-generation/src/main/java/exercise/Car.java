package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Data
@Value
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Car car;
        try {
            car = mapper.readValue(json, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    // END
}
