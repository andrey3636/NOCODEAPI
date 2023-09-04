package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateUserWithoutEmail extends BaseTest{
    String endpoint = "/users";

    @Test
    public void UnsuccessfulCreateUserWithoutEmail() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("")
                .full_name("Andrey")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        assertEquals(400, response.getStatusCode());

    }
}
