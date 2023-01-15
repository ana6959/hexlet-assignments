package exercise;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] image) {

        String[][] enlarge = new String[image.length * 2][image.length * 2];

        for (var i = 0; i < image.length; i++) {

            for (var j = 0; j < image.length; j++) {
                enlarge[i * 2][j * 2] = image[i][j];
                enlarge[i * 2 + 1][j * 2] = image[i][j];
                enlarge[i * 2][j * 2 + 1] = image[i][j];
                enlarge[i * 2 + 1][j * 2 + 1] = image[i][j];
            }

        }

        return enlarge;

    }
}
// END
