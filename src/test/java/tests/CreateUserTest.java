package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest extends BaseTest{
    String endpoint = "/users";

    @Test
    public void successfulCreateUser() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(getRandomEmail())
                .full_name("SFGGJ55")
                .password("123456")
                .generate_magic_link(false)
                .build();



        Response response = postRequest(endpoint, 201, requestBody);
        response.getStatusCode();

        Integer StatusCodeFromDeleteRequest = response.getStatusCode();

        String StatusCodeFromDeleteResponse = deleteRequest("/user/" + StatusCodeFromDeleteRequest ,200)
                .body().jsonPath().getString("200");

        assertEquals(StatusCodeFromDeleteRequest, StatusCodeFromDeleteResponse);

        deleteRequest("/users/" + getRequest("/users/",201),201);

    }

}
