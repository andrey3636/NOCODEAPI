package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Класс тестировщик создания пользователя
public class CreateUserWithoutEmail extends BaseTest{
    String endpoint = "/users";

    // Тест на неудачное создание пользователя без электронного адреса
    @Test
    public void UnsuccessfulCreateUserWithoutEmail() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("")
                .full_name("Andrey")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        // Проверка кода ответа
        assertEquals(400, response.getStatusCode());

    }
}
