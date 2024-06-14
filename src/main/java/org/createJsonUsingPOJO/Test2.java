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

        User2 user=new User2("sachin@gmail.com","sachin","sharma");

        user.addTechnoligies("c++");
        user.addTechnoligies("java");
        user.addTechnoligies("python");

        RequestSpecification request=RestAssured.given();

        request.contentType(ContentType.JSON);

        request.body(user).log().all().post(endPoint);
    }
}
