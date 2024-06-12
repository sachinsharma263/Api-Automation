package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class DeleteRequest {

    @Test
    public  void deleteRequest()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        RequestSpecification request=RestAssured.given();

        request.contentType("application/json");

        request.log().all();

        Response response=request.delete("users/2");

        System.out.println(response.statusCode());


    }
}
