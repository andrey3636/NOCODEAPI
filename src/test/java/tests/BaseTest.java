package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Random;

import static io.restassured.RestAssured.given;

// Класс формирования и реализации REST запросов
public class BaseTest {
    // Строка с базовым URI
    final static String BASE_URI = "https://studio-api.softr.io/v1/api";
    // Строка с ключом к API
    final static String API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    // Строка с доменом приложения
    final static String DOMAIN = "jere237.softr.app";

    // Базовая спецификация запроса
    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", API_KEY)
            .addHeader("Softr-Domain",DOMAIN )
            .build();

    // Метод генерации правильного случайного электронного адреса
    public static String getRandomEmail() {
        // Строка с доступными символами
        String SALTCHARS = "abcdefghijklmnopqrstufwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        // Генератор случайных чисел
        Random rnd = new Random();
        while (salt.length() < 20) { // Пока длина случайного адреса меньше 20
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            // Добавить случайный символ в конец строки
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }
    
    // Метод генерации неправильного случайного электронного адреса
    public static String getErrorEmail() {
        // Строка с доступными символами
        String SALTCHARS = "abcdefghijklmnopqrstufwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        // Генератор случайных чисел
        Random rnd = new Random();
        while (salt.length() < 20) { // Пока длина случайного адреса меньше 20
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            // Добавить случайный символ в конец строки
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "gmail.com";
    }
    
    // GET Запрос
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
    
    // GET Запрос с "телом"
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

    // GET Запрос с параметром
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

    // POST Запрос
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

    // PUT запрос
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

    // PUT запрос (удаление пользователя)
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
