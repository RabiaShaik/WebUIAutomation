@smoke
Feature: Invalid Login
  As an invalid users
  I should not be able to login successfully in to the system

    Scenario Outline: Login using invalid users
      Given I am on the sauce demo home page
      When I specify Username as "<userName>" and Password as "<password>"
      Then I should not be allowed to login
      Examples:
        | userName          | password            |
        |    invalidUser    |   secret_sauce      |
        |    bogusUser      |   test@123          |