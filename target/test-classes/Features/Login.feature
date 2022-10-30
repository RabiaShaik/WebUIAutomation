@smoke
Feature: Valid Login
  As a standard user
  I want to be able to login successfully in to the system

  Scenario: Login to the system

    Given I am on the sauce demo home page
    When  I specify Username as "standard_user" and Password as "secret_sauce"
    And   Click on LogIn button
    Then   I should be able to launch the products page