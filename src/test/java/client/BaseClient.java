package client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class BaseClient {
    protected RequestSpecification getSpec(){
        return RestAssured.given().baseUri(Constants.BASE_URL).header("Content-type", "application/json").filter(new AllureRestAssured());
    }
}
