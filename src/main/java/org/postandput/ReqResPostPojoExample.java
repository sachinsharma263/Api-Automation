package org.postandput;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ReqResPostPojoExample {


    public static  void main(String ar[])
    {
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification postRequest=RestAssured.given();

        Header reqHeader=new Header("Content-Type","application/json");

        postRequest.header(reqHeader);

       Ratings ratings=new Ratings();
       ratings.setT2020(1);
        ratings.setT2021(2);
        ratings.setAnnotation(List.of(10,20));

        PostRequestBody postRequestBody=new PostRequestBody();
        postRequestBody.setId(1);
        postRequestBody.setName("karthik");
        postRequestBody.setJob("lead");
        postRequestBody.setDesignations(List.of("sse","ja"));
        postRequestBody.setRating(ratings);

        postRequest.body(postRequestBody);
        Response response =postRequest.post("api/users")    ;

        response.prettyPrint();

        System.out.println("status code:"+ response.statusCode());


    }
}
