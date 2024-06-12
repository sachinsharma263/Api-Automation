package Cucumber.Driver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/weather_application.feature",glue = "Cucumber.stepDefinition")
public class CucumberDriver {
}
