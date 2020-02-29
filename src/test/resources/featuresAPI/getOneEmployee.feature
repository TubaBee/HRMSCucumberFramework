Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @OneEmp
  Scenario: This test will get One Employee
    Given user calls get one Employee API
    When user one retrieve response
    Then one Employee class status code is 200
    Then user validates employee is one
