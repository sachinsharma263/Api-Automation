package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

public class PostRequest {

    //how to send post request in rest assured
    @Test
    public void postRequest()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        RequestSpecification request=RestAssured.given();

        String contentType="application/json";

        request.contentType("application/json");

        File f=new File("D:\\intellij-workspace\\Api_Automation_Rest_Assured\\src\\main\\resources\\newuser.json");
        request.body(f).log().all();

       Response response= request.post("users");

       System.out.println("status code is:"+ response.statusCode());

       response.prettyPrint();

    }
}
