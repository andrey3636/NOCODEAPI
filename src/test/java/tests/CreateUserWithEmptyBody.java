package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CreateUserWithEmptyBody extends BaseTest{
    String endpoint = "/users";
    @Test
    public void UnsuccessfulCreateUserWithEmptyBody() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("")
                .full_name("")
                .password("")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 400, requestBody);

    }
}
