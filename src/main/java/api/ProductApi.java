package api;

import org.openqa.selenium.devtools.v141.network.model.Response;

import static io.restassured.RestAssured.given;

public class ProductApi {

    public Response getAllProducts() {
        return (Response) given()
                .when()
                .get(ApiEndpoints.PRODUCTS_LIST)
                .then()
                .extract()
                .response();
    }

    public Response getBrandsList() {
        return (Response) given()
                .when()
                .get(ApiEndpoints.BRANDS_LIST)
                .then()
                .extract()
                .response();
    }

    public Response searchProduct(String searchText) {
        return (Response) given()
                .queryParam("search_product", searchText)
                .when()
                .get(ApiEndpoints.SEARCH_PRODUCT)
                .then()
                .extract()
                .response();
    }
}
