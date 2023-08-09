package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteUserAfterDelete extends BaseTest {
    String endpoint = "/users/";
    String email = "qqqh@gmail.com";
    @Test
    public void successDelete(){
        Response response = deleteRequest(endpoint+email ,404);
    }
}
