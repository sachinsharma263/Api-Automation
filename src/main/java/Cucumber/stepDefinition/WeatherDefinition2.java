package Cucumber.stepDefinition;

import io.cucumber.java.*;
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

public class WeatherDefinition2 {

    RequestSpecification weatherRequest;
    Response responseWeather;

    @Before
    public void preCondition()
    {
        System.out.println("This is the before hook method");
    }
    @After
    public void tearDown()
    {
        System.out.println("This is the After hook method");
    }
    @BeforeAll
    public static void setAllPreCondition()
    {
        System.out.println("This is the BeforeAll hook method");
    }
    @AfterAll
    public static void allTearDown()
    {
        System.out.println("This is the AfterAll hook method");
    }
    @BeforeStep
    public void beforeStep()
    {
        System.out.println("This is the BeforeStep hook method");
    }
    @AfterStep
    public void AfterStep()
    {
        System.out.println("This is the AfterStep hook method");
    }
    @Given("City name and proper API key2")
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
    @When("The API is executed2")
    public void the_api_is_executed() {
        System.out.println("This is the When method");
         responseWeather =weatherRequest.get("/data/2.5/weather");
    }
    @Then("Check if the status code is2 200")
    public void check_if_the_status_code_is() {
        System.out.println("This is the Then method");
        Assert.assertEquals(200,responseWeather.statusCode());
        responseWeather.prettyPrint();
        //pojo
        WeatherResponse response=responseWeather.as(WeatherResponse.class);
        System.out.println("response after deserialized: "+response);


    }
    @Given("a sample city like2 {string}")
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







    }

