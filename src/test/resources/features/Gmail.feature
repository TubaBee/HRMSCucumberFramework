Feature: Gmail LOgin

  Scenario: Gmail
    Given I open the gmail page
    When I enter username
    When I click next button
    Then I enter password
    Then I click next button again
    Then I checck my login acception
