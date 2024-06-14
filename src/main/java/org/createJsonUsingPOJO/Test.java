package org.createJsonUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Test {

    @org.junit.Test
    public  void createUser()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        String endPoint="users";

        User user=new User("sachin@gmail.com","sachin","sharma");

        RequestSpecification request=RestAssured.given();

        request.contentType(ContentType.JSON);

        request.body(user).log().all().post(endPoint);
    }
}
