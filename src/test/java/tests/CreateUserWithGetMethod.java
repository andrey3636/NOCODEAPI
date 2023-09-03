package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Класс тестировщик создания пользователя
public class CreateUserWithGetMethod extends BaseTest {
    String endpoint = "/users";
    String email = getRandomEmail();

    // Тест на неудачное создание пользователя с помощью запроса GET
    @Test
    public void UnsuccessfulCreateUserWithGetMethod() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("Alo")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = getRequest(endpoint,requestBody);
        // Проверка кода ответа
        assertEquals(200, response.getStatusCode());
        
        // Запрос-предохранитель на удаление выше созданного пользователя
        response = deleteRequest(endpoint + "/" + email);
        // Проверка кода ответа
        assertEquals(400, response.getStatusCode());
    }
}
