package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserWithGetMethod extends BaseTest {
    String endpoint = "/users";
    String email = getRandomEmail();

    @Test
    public void UnsuccessfulCreateUserWithGetMethod() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("Alo")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = getRequest(endpoint,requestBody);
        assertEquals(200, response.getStatusCode());

        response = deleteRequest(endpoint + "/" + email);
        assertEquals(400, response.getStatusCode());
    }
}
