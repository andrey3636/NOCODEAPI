package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserWithIncorrectEmail extends BaseTest{
    String endpoint = "/users";
    @Test

    public void UnsuccessfulCreateUserWithIncorrectEmail() {
        String email = getErrorEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("Andrey")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        assertEquals(201, response.getStatusCode());

        response = deleteRequest(endpoint + "/" + email);
        assertEquals(200, response.getStatusCode());
    }
}
