package api;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
//import org.openqa.selenium.devtools.v141.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductApiTests {

    @BeforeClass
    public void setup() {
        ApiClient.initialize();
    }

    @Test
    public void verifyGetAllProductsList() {
        Response response =
                (Response) given()
                        .when()
                        .get(ApiEndpoints.PRODUCTS_LIST)
                        .then()
                        .extract()
                        .response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for products list API.");
        Assert.assertTrue(response.getBody().asString().contains("products"), "Response does not contain products data.");
    }

}
