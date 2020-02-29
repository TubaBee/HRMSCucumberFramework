Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @APIAll
  Scenario: This test will check to see All Employees
    Given user calls All Employee in API
    When All user retrieve response
    Then All employees status code is 200
    Then All user validates employee is created