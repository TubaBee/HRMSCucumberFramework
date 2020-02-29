Feature: Validating Syntax HRMS API's

  Background: 
    Given user generates token

  @JobT
  Scenario: This test will get Job Title
    Given user calls get Job Title list
    When user jobTitle retrieve response
    Then one jobTitle list class status code is 200
    Then user validates Job Title list
