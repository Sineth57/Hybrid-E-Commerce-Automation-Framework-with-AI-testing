package api;

import org.openqa.selenium.devtools.v141.network.model.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    public Response verifyLogin(String email, String password) {
        return (Response) given()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post(ApiEndpoints.VERIFY_LOGIN)
                .then()
                .extract()
                .response();
    }

    public Response createAccount(String name, String email, String password) {
        return (Response) given()
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("title", "Mr")
                .formParam("birth_date", "01")
                .formParam("birth_month", "January")
                .formParam("birth_year", "2000")
                .formParam("firstname", "John")
                .formParam("lastname", "Doe")
                .formParam("company", "TestCompany")
                .formParam("address1", "Street 1")
                .formParam("address2", "Street 2")
                .formParam("country", "India")
                .formParam("zipcode", "123456")
                .formParam("state", "TestState")
                .formParam("city", "TestCity")
                .formParam("mobile_number", "1234567890")
                .when()
                .post(ApiEndpoints.CREATE_ACCOUNT)
                .then()
                .extract()
                .response();
    }

    public Response updateAccount(String name, String email, String password) {
        return (Response) given()
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", password)
                .formParam("title", "Mr")
                .formParam("birth_date", "01")
                .formParam("birth_month", "January")
                .formParam("birth_year", "2000")
                .formParam("firstname", "John")
                .formParam("lastname", "Doe")
                .formParam("company", "UpdatedCompany")
                .formParam("address1", "Updated Address 1")
                .formParam("address2", "Updated Address 2")
                .formParam("country", "India")
                .formParam("zipcode", "654321")
                .formParam("state", "UpdatedState")
                .formParam("city", "UpdatedCity")
                .formParam("mobile_number", "9999999999")
                .when()
                .put(ApiEndpoints.UPDATE_ACCOUNT)
                .then()
                .extract()
                .response();
    }

    public Response deleteAccount(String email, String password) {
        return (Response) given()
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete(ApiEndpoints.DELETE_ACCOUNT)
                .then()
                .extract()
                .response();
    }
}
