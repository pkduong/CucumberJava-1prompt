Feature: SauceDemo login

  Scenario: Login successfully with a standard user
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    Then the products page is displayed
