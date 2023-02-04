package com.psrestassured.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class UtilsAPI {

    public static Response response;
    public static final Logger logger= LoggerFactory.getLogger(UtilsAPI.class);

    public static Response performGetRequest(RequestSpecification req, ResponseSpecification res, String endPoint) {
        logger.info("Calling " +endPoint + "API");
         response= RestAssured.given().spec(req).get(endPoint);
         logger.info("calling API- performed");
         return response;
    }

    public static void validateAPIHTTPStatus(RequestSpecification req, ResponseSpecification res, String endPoint, int code){

        logger.info("Validate " +endPoint + "API HTTP status:" +code);
        performGetRequest(req, res, endPoint)
                .then().spec(res);
        logger.info("validation performed");
    }
}
