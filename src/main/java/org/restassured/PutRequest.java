package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

public class PutRequest {

    @Test
    public  void putRequest()
    {

        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        RequestSpecification request=RestAssured.given();

        request.contentType("application/json");

        //https://reqres.in/api/users/2

        File f=new File("D:\\intellij-workspace\\Api_Automation_Rest_Assured\\src\\main\\resources\\updateuser.json");

        request.body(f).log().all();

        Response response=request.put("users/2");

        System.out.println(response.statusCode());
    }
}
