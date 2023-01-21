@GreenKart
Feature: Verify shipment of Green Kart
  Scenario: Successfully add two items to cart and shipped to United States
    Given User go to Green Kart home page
    And User verify the page title
    When User capture all items from the page
    And Print sorted prices in decending order
    And Add second plus third item in the cart
    Then User go to cart page
    And User verify the total price
    And User go to next page to select country "United States"
    And User verify successfully shiped items "Thank you, your order has been placed successfully"