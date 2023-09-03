package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Класс тестировщик создания пользователя
public class CreateUserTest extends BaseTest {
    String endpoint = "/users";

    // Удачно созданный пользователь
    @Test
    public void successfulCreateUser() {

        String email = getRandomEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJ55")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        // Проверка кода ответа
        assertEquals(201, response.getStatusCode());

        // Запрос-предохранитель на удаление выше созданного пользователя
        response = deleteRequest(endpoint + "/" + email);
        // Проверка кода ответа
        assertEquals(200, response.getStatusCode());
    }
}
