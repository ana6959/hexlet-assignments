package exercise;

//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
//import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void testEnlargeArrayImage() {

        String[][] image = {
                {"+", "*", "*", "+"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"-", "*", "*", "-"},
        };
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {
                {"+", "+", "*", "*", "*", "*", "+", "+"},
                {"+", "+", "*", "*", "*", "*", "+", "+"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"-", "-", "*", "*", "*", "*", "-", "-"},
                {"-", "-", "*", "*", "*", "*", "-", "-"},
        };
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArrayImageEmpty() {

        String[][] image = {};
        String[][] actual = App.enlargeArrayImage(image);
        String[][] expected = {};
        assertThat(actual).isEqualTo(expected);
    }
}

// END
