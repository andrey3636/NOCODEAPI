package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserWithoutPassword extends BaseTest{
    String endpoint = "/users";
    @Test
    public void UnsuccessfulCreateUserWithoutPassword() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("99999@gmail.com")
                .full_name("SFGGJ55")
                .password("")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, requestBody);
        assertEquals(400, response.getStatusCode());

    }
}
