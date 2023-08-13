package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserWithGetMethod extends BaseTest{
    String endpoint = "/users";
    @Test
    public void UnsuccessfulCreateUserWithGetMethod() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("qq87h@gmail.com")
                .full_name("Alo")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = getRequest(endpoint);
        assertEquals(400, response.getStatusCode());

    }


}
