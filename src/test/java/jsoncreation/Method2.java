package jsoncreation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Method2 {

    @Test
    public void sendPostRequestUsingHashMap()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="api/";

        String endPoint="users";

        RequestSpecification request=RestAssured.given();

       // request.contentType(ContentType.JSON);

        HashMap<String,String> map=new HashMap<String,String>();

        map.put("name","Rahul");
        map.put("designation","Team Lead");
        map.put("job","developer");

        //System.out.println(map);

        List<String> listOfTechnologies=new ArrayList<String>();
        listOfTechnologies.add("c++");
        listOfTechnologies.add("java");
        listOfTechnologies.add("python");

        map.put("technology",listOfTechnologies.toString());

        //System.out.println(map);

        request=request.body(map).log().all();
        Response response=request.post(endPoint);

        System.out.println("---------------");

        System.out.println(response.statusCode());
        response.prettyPrint();




    }
}
