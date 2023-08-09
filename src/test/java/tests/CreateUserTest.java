package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest{
    String endpoint = "/users";

    @Test
    public void successfulCreateUser() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("qqqh9@gmail.com")
                .full_name("SFGGJ55")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);

    }

}
