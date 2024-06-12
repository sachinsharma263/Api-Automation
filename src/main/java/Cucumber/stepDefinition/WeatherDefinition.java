package Cucumber.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.weather.WeatherResponse;

import java.util.HashMap;
import java.util.Map;

public class WeatherDefinition {

    RequestSpecification weatherRequest;
    Response responseWeather;

    @Given("City name and proper API key")
    public void city_name_and_proper_api_key() {
        System.out.println("This is the given method");
        RestAssured.baseURI="https://api.openweathermap.org";

        //when we call give method, returns the instance of RequestSpecification(but the class implementing it)
         weatherRequest=RestAssured.given();

        Map<String,String> weatherQueryParams=new HashMap<String,String>();
        weatherQueryParams.put("q","mumbai");
        weatherQueryParams.put("appid","5bacd68731696bde8fe793605775d6f5");


        //setting the context of query parameter inside the request
        weatherRequest.queryParams(weatherQueryParams);


        Header requestHeaders=new Header("Content-Type","application/json");

        //setting the request header
        weatherRequest.header(requestHeaders);



    }
    @When("The API is executed")
    public void the_api_is_executed() {
        System.out.println("This is the When method");
         responseWeather =weatherRequest.get("/data/2.5/weather");
    }
    @Then("Check if the status code is 200")
    public void check_if_the_status_code_is() {
        System.out.println("This is the Then method");
        Assert.assertEquals(200,responseWeather.statusCode());
        responseWeather.prettyPrint();
        //pojo
        WeatherResponse response=responseWeather.as(WeatherResponse.class);
        System.out.println("response after deserialized: "+response);


    }

    @Given("a sample city like {string}")
    public void a_sample_city_like_chennai(String cityName) {
        System.out.println("This is the given method");
        RestAssured.baseURI="https://api.openweathermap.org";

        //when we call give method, returns the instance of RequestSpecification(but the class implementing it)
        weatherRequest=RestAssured.given();

        Map<String,String> weatherQueryParams=new HashMap<String,String>();
        weatherQueryParams.put("q",cityName );
        weatherQueryParams.put("appid","5bacd68731696bde8fe793605775d6f5");


        //setting the context of query parameter inside the request
        weatherRequest.queryParams(weatherQueryParams);


        Header requestHeaders=new Header("Content-Type","application/json");

        //setting the request header
        weatherRequest.header(requestHeaders);
    }

    @Given("a sample city like {string} with api key {string}")
    public void aSampleCityLikeWithApiKey(String cityName, String api) {
        System.out.println("This is the given method");
        RestAssured.baseURI="https://api.openweathermap.org";

        //when we call give method, returns the instance of RequestSpecification(but the class implementing it)
        weatherRequest=RestAssured.given();

        Map<String,String> weatherQueryParams=new HashMap<String,String>();
        weatherQueryParams.put("q",cityName );
        weatherQueryParams.put("appid",api);


        //setting the context of query parameter inside the request
        weatherRequest.queryParams(weatherQueryParams);


        Header requestHeaders=new Header("Content-Type","application/json");

        //setting the request header
        weatherRequest.header(requestHeaders);
    }

    @Then("Check if the status code is {int} or not")
    public void checkIfTheStatusCodeIsOrNot(int statusCode) {
        System.out.println("This is the Then method");
        Assert.assertEquals(statusCode,responseWeather.statusCode());



    }
    }
