package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreateUserTest extends BaseTest{
    String endpoint = "/users";

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
        assertEquals(201, response.getStatusCode());

        response = deleteRequest(endpoint + "/" + email);
        assertEquals(200, response.getStatusCode());

    }

}
