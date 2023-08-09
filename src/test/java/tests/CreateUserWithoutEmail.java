package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

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

        Response response = postRequest(endpoint, 400, requestBody);

    }
}
