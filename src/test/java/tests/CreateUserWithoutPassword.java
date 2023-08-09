package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

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

        Response response = postRequest(endpoint, 400, requestBody);

    }
}
