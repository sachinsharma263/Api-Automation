package org.postandput;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReqResPostExample {


    public static  void main(String ar[])
    {
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification postRequest=RestAssured.given();

        Header reqHeader=new Header("Content-Type","application/json");

        postRequest.header(reqHeader);

        JSONObject reqBody=new JSONObject();
        reqBody.put( "name", "morpheus");
        reqBody.put( "job", "leader");
        reqBody.put( "id", 200);

        JSONArray designationsArray=new JSONArray();
        designationsArray.put("ja");
        designationsArray.put("sse");
        designationsArray.put("lead");

        reqBody.put("designations",designationsArray);

        JSONObject ratings=new JSONObject();
        ratings.put("200",1).put("2021",2);

        JSONArray annoationArray=new JSONArray();
        annoationArray.put(10).put(20).put(30);

        ratings.put("annoation",annoationArray);

        reqBody.put("ratings",ratings);

        postRequest.body(reqBody.toString());

        Response response =postRequest.post("api/users");

        response.prettyPrint();

        System.out.println("status code:"+ response.statusCode());


    }
}
