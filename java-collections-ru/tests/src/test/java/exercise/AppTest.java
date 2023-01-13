package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int number1 = 3;
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> actual1 = App.take(list1, number1);
        assertThat(actual1).isEqualTo(expected1);

        int number2 = 0;
        List<Integer> expected2 = new ArrayList<>();
        List<Integer> actual2 = App.take(list1, number2);
        assertThat(actual2).isEqualTo(expected2);

        int number3 = 20;
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> actual3 = App.take(list1, number3);
        assertThat(actual3).isEqualTo(expected3);

        List<Integer> list2 = new ArrayList<>();

        int number4 = 5;
        List<Integer> expected4 = new ArrayList<>();
        List<Integer> actual4 = App.take(list2, number4);
        assertThat(actual4).isEqualTo(expected4);

        // END
    }
}
