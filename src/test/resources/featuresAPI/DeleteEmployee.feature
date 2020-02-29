Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @delEmp
  Scenario: This test will delete an Employee
    Given user calls deleteEmployee API
    When user delete retrieve response
    Then delete class status code is 200
    Then user validates employee is deleted
