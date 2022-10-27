package apiTraining;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqresTests {

    @Test
    void loginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .log().uri()
                .log().body()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", Matchers.is("QpwL5tke4Pnpja7X4"));
    }

        @Test
        void negativeLoginTest() {
            String body = "{ \"email\": \"eve.holt@reqres.in\"}";

            given()
                    .log().uri()
                    .log().body()
                    .body(body)
                    .contentType(ContentType.JSON)
                    .when()
                    .post("https://reqres.in/api/login")
                    .then()
                    .log().status()
                    .log().body()
                    .statusCode(400)
                    .body("error", Matchers.is("Missing password"));


        }
}
