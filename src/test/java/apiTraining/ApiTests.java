package apiTraining;

import io.restassured.response.ValidatableResponse;
import models.Product;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class ApiTests {

    @Test
   public void getCategories() {
        String endpoint = "http://localhost:8888/API_testing/product/read.php";

      //  ValidatableResponse response =
                given().
                        when().
                        get(endpoint).
                        then().
                        log().headers().
                assertThat().
                statusCode(200).
                        header("Content-Type", Matchers.equalTo("application/json; charset=UTF-8")).
                body("records.size()", Matchers.greaterThan(2)).
                body("records.id", Matchers.everyItem(Matchers.notNullValue())).
                body("records.name", Matchers.everyItem(Matchers.notNullValue())).
                body("records.description", Matchers.everyItem(Matchers.notNullValue())).
                body("records.price", Matchers.everyItem(Matchers.notNullValue())).
                body("records.category_id", Matchers.everyItem(Matchers.notNullValue())).
                body("records.category_name", Matchers.everyItem(Matchers.notNullValue())).
                body("records.id[0]", Matchers.equalTo("23"));

    }

    @Test
    void getProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/read_one.php";

        ValidatableResponse response = given().
                queryParam("id", 2).
                when().
                get(endpoint).
                then().log().body().
                assertThat().
                statusCode(200).
                body("id", Matchers.equalTo("2")).
                body("name", Matchers.equalTo("Cross-Back Training Tank")).
                body("description", Matchers.equalTo("The most awesome phone of 2013!")).
                body("price", Matchers.equalTo("299.00")).
                body("category_id", Matchers.equalTo("2")).
                body("category_name", Matchers.equalTo("Active Wear - Women"));

    }

    @Test
    void createProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/create.php";
        String body = "{\n" +
                "                \"name\": \"Wodka Bottle\",\n" +
                "                \"description\": \"Blue water bottle. Hold 64 ounces\",\n" +
                "                \"price\": 15,\n" +
                "                \"category_id\": 4\n" +
                "\n" +
                "                }";

        ValidatableResponse response = given().body(body).when().post(endpoint).then();
        response.log().body();

    }

    @Test
    void updateProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/update.php";
        String body = "" +
                "{\n" +
                "    \"id\": 21,\n" +
                "    \"name\": \"Whiskey Bottle666\",\n" +
                "    \"description\": \"Blue Whiskey bottle. Hold 55 ounces\",\n" +
                "    \"price\": 777,\n" +
                "    \"category_id\": 2\n" +
                "    \"category_name\": \"Blue Whiskey bottle. Hold 55 ounces\",\n" +
                "\n" +
                "}";
        ValidatableResponse response = given().body(body).when().put(endpoint).then();
        response.log().body();


    }

    @Test
    void deleteProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/delete.php";
        String body = "" +
                "{\n" +
                " \"id\": 22\n" +
                "  }";
        ValidatableResponse response = given().body(body).when().delete(endpoint).then();
        response.log().body();




    }

    @Test
    void createSerializedProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/create.php";
        Product product = new Product(
            "Beer Can",
                "Tasty Lager Beer",
                27,
                3
        );

        ValidatableResponse response = given().body(product).when().post(endpoint).then();
        response.log().body();

    }

    @Test
    void getDeserializeProduct() {
        String endpoint = "http://localhost:8888/API_testing/product/read_one.php";
        given().
                queryParam("id", "2").
                when().
                get(endpoint).
                as(Product.class);


    }
}
