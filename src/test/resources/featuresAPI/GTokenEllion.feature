Feature: Generate Token

  @token
  Scenario: Generating Token
    When I provide the header for Generating Token
    And I provide the bpdy for Genarating Token
    And I make Generate Token call
    Then I validate the Genarate Token status code
    And I get the token from the response
