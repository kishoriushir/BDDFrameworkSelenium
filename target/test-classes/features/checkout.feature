
@tag
Feature: Place the order for Products
 

  @placeOrder
  Scenario Outline: Search product and place the order   
    Given User is on GREENKART landing page
    When User searched with Shortname <Name> and extracted actual name of product 
    And Added "3" items of the selected product to cart 
    Then User proceed to Checkout and validate the <Name> items in checkout page  
    And Verify user has ablity to enter promo code and place the order 
    And Verify the user is redirected on GREENKART landing page after place the order
   
   Examples:
   |Name|
   |Tom|
   |Broc|
   
 @placeOrderwithoutselectingtermsandconditions
  Scenario Outline: Search product and place the order without accepting the terms and conditions   
    Given User is on GREENKART landing page
    When User searched with Shortname <Name> and extracted actual name of product 
    And Added "3" items of the selected product to cart 
    Then User proceed to Checkout and validate the <Name> items in checkout page  
    And Verify user has ablity to enter promo code and place the order without accepting terms and conditions
    
   
   Examples:
   |Name|
   |Tom|
   |Broc|
   
 
