Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @update
  Scenario: This test will check to see if an Employee is updated
    Given user calls update Employee API
    When update user retrieve response
    Then update class status code is 200
    Then user validates employee is updated
