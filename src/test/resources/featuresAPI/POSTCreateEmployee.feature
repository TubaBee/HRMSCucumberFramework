Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @APITEST
  Scenario: This test will check to see if an Employee is created
    Given user calls create Employee API
    When user retrieve response
    Then status code is 200
    Then user validates employee is created
