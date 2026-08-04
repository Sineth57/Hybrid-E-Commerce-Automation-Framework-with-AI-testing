package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private static RequestSpecification requestSpec;

    private ApiClient() {
    }

    public static RequestSpecification getRequestSpec() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(ApiEndpoints.BASE_URI)
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    .build();
        }
        return requestSpec;
    }

    public static void initialize() {
        RestAssured.requestSpecification = getRequestSpec();
    }
}
