@TutorialsNinjaAddtoCart
Feature: Adding a Product to the Shopping Cart on TutorialsNinja

  Scenario: Adding a Product to the Shopping Cart
    Given the User opens the application
    When User enters the valid product 'HP' in the search bar
    And User clicks on the Product search button
    Then User sees valid product information in the SearchPage
    When User clicks on the product 'HP'
    And User clicks on the add to cart button
    Then User should see the product added successfully to the cart message
