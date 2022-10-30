@smoke
Feature:
  As a standard user
  I want to be able to sort the products by price (high to low)
  So that I can add the cheapest and the second costliest products to the basket and purchase it


  Background: Login Scenario
    Given I am on the sauce demo home page
    When I specify Username as "standard_user" and Password as "secret_sauce"
    And Click on LogIn button

  Scenario: Purchase the product after sorting

    Given I click on price high to low
    When  I click on cheapest and the second costliest product
    And   Checking out the products
    And   Input the purchase details
    And   I should be able to see the payment and shipping information and key in "John", "Smith" and "62501"
    Then  I should be finish the purchase