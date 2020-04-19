Feature: GetAlbums

  @GoRest
  Scenario: 
    Given i provide th request data
    When i make a call to album API
    Then I validate that 200 is the status code
    And I validate to response body
