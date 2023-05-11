package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {

        List<String> notValidList = new ArrayList<>();

        Field[] declaredFields = address.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address)== null) {
                        notValidList.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidList;
    }


}
// END
