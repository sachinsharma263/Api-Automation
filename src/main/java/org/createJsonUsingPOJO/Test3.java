package org.createJsonUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Test3 {

    @org.junit.Test
    public  void createUser()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        String endPoint="users";

        User3 user3=new User3("sachin@gmail.com","sachin","sharma");

        user3.addTechnoligies("c++");
        user3.addTechnoligies("java");
        user3.addTechnoligies("python");

        Address address=new Address("1","5","delhi","delhi","india",324234);
        user3.setAddress(address);

        RequestSpecification request=RestAssured.given();

        request.contentType(ContentType.JSON);

        request.body(user3).log().all().post(endPoint);
    }
}
