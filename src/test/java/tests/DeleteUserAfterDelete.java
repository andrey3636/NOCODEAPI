package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Класс тестировщик удаления пользователя
public class DeleteUserAfterDelete extends BaseTest {
    String endpoint = "/users/";
    
    // Тест на удачное удаление пользователя и неудачное повторное удаление
    @Test
    public void successDelete() {
        String email = getRandomEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJ55")
                .password("123456")
                .generate_magic_link(false)
                .build();

        // Создание случайного пользователя
        Response response = postRequest(endpoint, requestBody);
        // Проверка кода ответа
        assertEquals(201, response.getStatusCode());
        response = deleteRequest(endpoint + email);
        // Проверка кода ответа
        assertEquals(200, response.getStatusCode());
        response = deleteRequest(endpoint + email);
        // Проверка кода ответа
        assertEquals(404, response.getStatusCode());
    }
}
