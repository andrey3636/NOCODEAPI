package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// Класс тестировщик создания пользователя
public class CreateUserWithoutPassword extends BaseTest{
    String endpoint = "/users";
    String email = getRandomEmail();

    // Тест на неудачное создание пользователя без пароля
    @Test
    public void UnsuccessfulCreateUserWithoutPassword() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJ55")
                .password("")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        // Проверка кода ответа
        assertEquals(400, response.getStatusCode());
    }
    
    @AfterEach
    public void after (){
        // Запрос-предохранитель на удаление выше созданного пользователя
         deleteRequest(endpoint + "/" + email);
    }
}
