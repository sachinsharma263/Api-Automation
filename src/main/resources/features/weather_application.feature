Feature: Test Weather application

  Scenario: Test if we get the proper output for weather api positive case
    Given City name and proper API key
    When The API is executed
    Then Check if the status code is 200

  Scenario: Test the weather api for chennai city
    Given a sample city like "chennai"
    When The API is executed
    Then Check if the status code is 200

  Scenario: Test the weather api for chennai city with api key
    Given a sample city like "chennai" with api key "5bacd68731696bde8fe793605775d6f5"
    When The API is executed
    Then Check if the status code is 200 or not

    Scenario Outline: Test the weather api for multiple cities
      Given a sample city like <city> with api key <api_key>
      When The API is executed
      Then Check if the status code is 200 or not
      Examples:
        | city |api_key|
        | "Delhi" |"5bacd68731696bde8fe793605775d6f5"|
        | "mumbai" |"5bacd68731696bde8fe793605775d6f5"|
        | "chennai" |"5bacd68731696bde8fe793605775d6f5"|