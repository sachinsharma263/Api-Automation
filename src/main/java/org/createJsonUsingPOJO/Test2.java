package org.createJsonUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Test2 {

    @org.junit.Test
    public  void createUser()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        String endPoint="users";

        User2 user2=new User2("sachin@gmail.com","sachin","sharma");

        user2.addTechnoligies("c++");
        user2.addTechnoligies("java");
        user2.addTechnoligies("python");

        RequestSpecification request=RestAssured.given();

        request.contentType(ContentType.JSON);

        request.body(user2).log().all().post(endPoint);
    }
}
