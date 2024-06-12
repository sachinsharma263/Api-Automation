package org.restassured;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.weather.WeatherResponse;

import java.util.HashMap;
import java.util.Map;

public class WeatherApplication
{
    public static void main(String[] args) {

        //https://api.openweathermap.org/data/2.5/weather?q=mumbai&appid=5bacd68731696bde8fe793605775d6f5
        //URI
        RestAssured.baseURI="https://api.openweathermap.org";

        //when we call give method, returns the instance of RequestSpecification(but the class implementing it)
       // RequestSpecification weatherRequest=RestAssured.given().contentType("application/json");
        //RequestSpecification weatherRequest=RestAssured.given().contentType(ContentType.JSON);


        RequestSpecification weatherRequest=RestAssured.given();

       // String contentType="application/json";
       // weatherRequest.contentType(contentType);


        Map<String,String> weatherQueryParams=new HashMap<String,String>();
        weatherQueryParams.put("q","mumbai");
        weatherQueryParams.put("appid","5bacd68731696bde8fe793605775d6f5");


        //setting the context of query parameter inside the request
        weatherRequest.queryParams(weatherQueryParams);


        Header requestHeaders=new Header("Content-Type","application/json");

        //setting the request header
        weatherRequest.header(requestHeaders);

        Response responseWeather =weatherRequest.get("/data/2.5/weather");

        responseWeather.prettyPrint();

        //getting the status code
        System.out.println("the status code of request: "+responseWeather.statusCode());
        System.out.println("the time of request: "+responseWeather.getTime());


        System.out.println("---------------------------------------");
        //Root of json is $ representation/here in java the root is responseWeather
        //from root if we want to get child node: we use . operator
        //parse the data
        String cityName=responseWeather.jsonPath().getString("name");
        //System.out.println("the cityName: "+cityName);

        String coordinate=responseWeather.jsonPath().getString("coord");
        //System.out.println("the coordinate: "+coordinate);



       // String coordinate2=responseWeather.jsonPath().get("coord");
        Map<String,Object> map=responseWeather.jsonPath().get("coord");
       // System.out.println("the coordinates: "+map);

//serliazable/deseriazable

        WeatherResponse response=responseWeather.as(WeatherResponse.class);

        System.out.println(response);

        System.out.println(response.getWeather());

        JsonNode weatherData=response.getMain();


        int id=response.getWeather().get(0).getId();
        JsonNode temp_max=weatherData.get("temp_max");

        Assert.assertEquals(721,id);

        System.out.println("The temperature max is:"+ weatherData.get("temp_max"));





    }
}
