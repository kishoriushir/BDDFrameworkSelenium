
@tag
Feature: Search and place the order for products
 

  @searchProductsandOffersPage
  Scenario Outline: Search Experience for product search in both home and offers page   
    Given User is on GREENKART landing page
    When User searched with Shortname <Name> and extracted actual name of product 
    Then User search for <Name> shortname in offer page
    And Validate product name in offerpage matches with landing page
   
   Examples:
   |Name|
   |Tom|
   |Beet|

 
