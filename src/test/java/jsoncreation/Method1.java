package jsoncreation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class Method1 {

    //create json
    //as a file and sending in body
    //create json object and json array
   @Test
    public void createUser() {

       RestAssured.baseURI="https://reqres.in/";
       RestAssured.basePath="api/";

       String endPoint="users";

       RequestSpecification request=RestAssured.given();

       request.contentType("application/json");

       JSONObject json=new JSONObject();
       json.put("name","Rahul");
       json.put("job","Team Lead");
       json.put("designation","developer");

       JSONArray jsonArray=new JSONArray();
       jsonArray.put("c++");
       jsonArray.put("java");
       jsonArray.put("python");

       json.put("technology",jsonArray);

       //System.out.println(json);

       JSONObject address=new JSONObject();
       address.put("city","delhi");
       address.put("country","india");

       json.put("address",address);

       request.body(json.toString()).log().all();

      Response response=request.post(endPoint);


      //response.prettyPrint();







    }
}
