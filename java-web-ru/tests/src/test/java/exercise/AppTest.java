package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("users");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @Test
    void testCreateUserValid() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users/")
                .field("firstName", "Joe")
                .field("lastName", "Biden")
                .field("email", "jb@gmail.com")
                .field("password", "1234")
                .asString();

        assertThat(responsePost.getStatus()).isEqualTo(302);

        User testUser = new QUser()
                .firstName.equalTo("Joe")
                .findOne();
        assertThat(testUser).isNotNull();
        assertThat(testUser.getLastName()).isEqualTo("Biden");
        assertThat(testUser.getPassword()).isEqualTo("1234");

    }

    @Test
    void testCreateUserInvalid() {
        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users/")
                .field("firstName", "Don")
                .field("lastName", "")
                .field("email", "jb.gmail.com")
                .field("password", "11")
                .asString();

        assertThat(responsePost.getStatus()).isEqualTo(422);

        User testUser = new QUser()
                .firstName.equalTo("Don")
                .findOne();
        assertThat(testUser).isNull();
     
    }





    // END
}
