package exercise;

import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;

// BEGIN
class App {

    public static int getCountOfFreeEmails(List<String> emailsList) {

        List<String> freeDomains = new ArrayList<>();
        freeDomains.add("gmail.com");
        freeDomains.add("yandex.ru");
        freeDomains.add("hotmail.com");

        int count = 0;
        String[] emailSplit;
        for (String email: emailsList) {
            emailSplit = email.split("@");

            if (freeDomains.contains(emailSplit[1])) {
                count++;
            }
        }

        return count;

    }
}
// END
