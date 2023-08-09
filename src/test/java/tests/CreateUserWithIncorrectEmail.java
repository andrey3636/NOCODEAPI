package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CreateUserWithIncorrectEmail extends BaseTest{
    String endpoint = "/users";
    @Test
    public void UnsuccessfulCreateUserWithIncorrectEmail() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("999@gmail.c")
                .full_name("Andrey")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);

    }
}
