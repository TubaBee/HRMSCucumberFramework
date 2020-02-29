Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @Status
  Scenario: This test will get Employee status List
    Given user calls get Employee status list
    When user status retrieve response
    Then Employee status list class status code is 200
    Then user validates employee status list