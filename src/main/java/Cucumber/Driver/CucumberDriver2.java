package Cucumber.Driver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/weather_application2.feature",glue = "Cucumber.stepDefinition",tags="@chennai")
public class CucumberDriver2 {
}
