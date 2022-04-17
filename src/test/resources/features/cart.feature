@Purchase
Feature: Amazon purchase
  In order to purchase something
  As a customer
  I want to add an item

  @AddingSuccess
  Scenario: Add an item
    Given juan navigates to www.amazon.com
    And Searches for Alexa
    And navigates to the second page
    And selects the third item
    Then assert that the item would be available for purchase


