package exercise;

// BEGIN
public class App {

    public static int printSquare(Circle circle) {

        try {
            int square = (int)Math.round(circle.getSquare());
            System.out.println(square);
            return square;
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }

        return 0;
    }

}
// END
