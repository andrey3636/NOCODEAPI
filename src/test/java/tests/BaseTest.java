package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class BaseTest {
    final static String BASE_URI = "https://studio-api.softr.io/v1/api";
    final static String API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    final static String DOMAIN = "jere237.softr.app";

    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", API_KEY)
            .addHeader("Softr-Domain",DOMAIN )
            .build();

    public static String getRandomEmail() {
        String SALTCHARS = "abcdefghijklmnopqrstufwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 20) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    public static String getErrorEmail() {
        String SALTCHARS = "abcdefghijklmnopqrstufwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 20) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "gmail.com";
    }

    public static Response getRequest(String endPoint) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public static Response getRequest(String endPoint, Object body) {
        RequestSpecification spec = given()
                .spec(specification);
        if (body != null){
            spec.body(body);
        }
        Response response = spec
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response getRequestWithParam(String endPoint, String paramName, int id) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .pathParam(paramName, id)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response postRequest(String endPoint, Object body) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response putRequest(String endPoint, Object body) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response deleteRequest(String endPoint) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

}
