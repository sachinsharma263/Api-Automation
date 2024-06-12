@Weather
Feature: Test Weather application

  @weather_get
  Scenario: Test if we get the proper output for weather api positive case
    Given City name and proper API key2
    When The API is executed2
    Then Check if the status code is2 200

  @chennai
  Scenario: Test the weather api for chennai city
    Given a sample city like2 "chennai"
    When The API is executed2
    Then Check if the status code is2 200
