package com.psrestassured.apiObjects;

import com.psrestassured.helpers.UtilsAPI;
import com.psrestassured.pojoobjects.ListUsers;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.Assert;

public class ListUsersAPIObject extends UtilsAPI {

    public static void validateHeadersListUsersAPI(String basePath, String endPoint, int code) {
        RestAssured.get(basePath+endPoint)
                .then()
                .assertThat()
                .statusCode(code)
                .and()
                .contentType(ContentType.JSON)
                .and().assertThat()
                .header("Server", "cloudflare");
    }

    public static ListUsers parseAPIResponseToPojo(String basePath, String endPoint){

        return RestAssured.get(basePath+endPoint).as(ListUsers.class);
    }

    public static void validatePageFieldFromResponse(ListUsers actual, ListUsers expected){

        Assert.assertEquals(actual.getPage(), expected.getPage());
    }
}