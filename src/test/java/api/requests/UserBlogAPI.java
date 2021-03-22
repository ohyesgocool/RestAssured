package api.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Reporter;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserBlogAPI {

    public Response response;

    public Response getUserBlog(String pathParam) {

        try {
            // BaseURL or Host
            RestAssured.baseURI = Utils.getGlobalValue("baseurl");
        } catch (IOException e) {
            Reporter.log("Exception in Setting Base URL", true);

        }
        response = given()
                    .when().get(pathParam).then().log().all().extract().response();
        return response;
    }

}
