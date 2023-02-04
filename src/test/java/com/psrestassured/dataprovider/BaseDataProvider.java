package com.psrestassured.dataprovider;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psrestassured.pojoobjects.ListUsers;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseDataProvider {

    Object obj;
    String testDataDir="src/test/resources/testData/";
    String apiName;
    String payLoadType=".json";

    public ObjectMapper objectMapper;

    @DataProvider
    public Object[][] names(){

        return new Object[][]{
                {"andrejs-ps"}, {"rest-assured"}
        };
    }

    @DataProvider(name="")
    public Object[][] pageNumber(){

        return new Object[][]{
                {"1"}, {"4"}
        };
    }

    @DataProvider(name = "getUsersList")
    public Object[][] getDataFromFile(Method method) throws Throwable {
        apiName=method.getName().substring(method.getName().lastIndexOf('_') +1);
        Object data=readDataFromFileForCurrentMethod(apiName);
        return new Object[][]{
            {data, 200}

        };
    }

    public Object readDataFromFileForCurrentMethod(String apiName) throws Throwable, StreamReadException {
        String payloadPath=testDataDir+apiName+payLoadType;
        objectMapper= new ObjectMapper();

        switch (apiName){
            case "listUsers" :
                ListUsers obj=objectMapper.readValue(new File(payloadPath), ListUsers.class);
                return obj;
            default:
        }
        return obj;
    }

}
