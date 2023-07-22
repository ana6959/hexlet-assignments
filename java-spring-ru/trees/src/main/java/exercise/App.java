package exercise;

import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // Запускаем приложение
        SpringApplication.run(App.class, args);

    }
}
