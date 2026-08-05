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
        ProductApi productApi = new ProductApi();
        Response response = (Response) productApi.getAllProducts();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for products list API.");
        Assert.assertTrue(response.getBody().asString().contains("products"), "Response does not contain products data.");
    }

    @Test
    public void verifyBrandsList() {
        ProductApi productApi = new ProductApi();
        Response response = (Response) productApi.getBrandsList();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for brands list API.");
        Assert.assertTrue(response.getBody().asString().contains("brands"), "Response does not contain brands data.");
    }

    @Test
    public void verifySearchProduct() {
        ProductApi productApi = new ProductApi();
        Response response = (Response) productApi.searchProduct("shirt");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for search product API.");
        Assert.assertTrue(response.getBody().asString().length() > 0, "Search product response is empty.");
    }

}
