package com.psrestassured.testscripts;

import com.psrestassured.apiObjects.ListUsersAPIObject;
import com.psrestassured.dataprovider.BaseDataProvider;
import com.psrestassured.pojoobjects.Data;
import com.psrestassured.pojoobjects.ListUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ListUsersAPITest  {

    ListUsers listUsers;

    public String BASE_URL;
    public String LIST_USER;
    public Response response;
    public RequestSpecification req;
    public ResponseSpecification res;

    @Given("BaseURL and EndPoint URI is established")
    public void base_url_and_end_point_uri_is_established() {
        Properties config = new Properties();
        FileInputStream fs;

        {
            try {
                fs = new FileInputStream("src/test/resources/config.properties");
                config.load(fs);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        BASE_URL = config.getProperty("BASE_URL");
        LIST_USER = config.getProperty("LIST_USER");
        req = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
        res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).
                expectStatusCode(200).build();


    }
    @When("user calls {string} with GET request")
    public void user_calls_with_get_request(String endPoint){

        ListUsersAPIObject.performGetRequest(req , res, endPoint);
        // ListUsersAPIObject.validateHeadersListUsersAPI(BASE_URL, LIST_USER);
    }

    @Then("the API call gets success with status code {int}")
    public void the_api_call_gets_success_with_status_code( Integer code){

        ListUsersAPIObject.validateAPIHTTPStatus(req , res, LIST_USER, code);
    }

   /* @Test(dataProvider = "getUsersList", dataProviderClass = BaseDataProvider.class)
    public void asUserWouldLikeToValidateHeaders_listUsers(Object data, Integer code){

        ListUsersAPIObject.validateHeadersListUsersAPI(BASE_URL ,LIST_USER, code);

    }*/
  /*  @Test(dataProvider = "getUsersList", dataProviderClass = BaseDataProvider.class)
    public void asUserWouldLikeToValidatePayloadUsingPojo_listUsers(ListUsers data, int code){

        ListUsersAPIObject.validateAPIHTTPStatus_OK(req ,res, LIST_USER);
        listUsers= ListUsersAPIObject.parseAPIResponseToPojo(BASE_URL , LIST_USER);
        ListUsersAPIObject.validatePageFieldFromResponse(listUsers, data);
    }*/
}
