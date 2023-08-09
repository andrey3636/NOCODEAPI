package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DeleteUserTest extends BaseTest{

    String endpoint = "/users/";
    String email = "888@gmail.com";
    @Test
    public void successDelete(){
        Response response = deleteRequest(endpoint+email ,200);
    }

}
