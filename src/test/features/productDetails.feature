Feature: Product details features
  Scenario: Should show product details when click on product from product list
    Given Open homepage
    When Search dress using search box
    And Click on product
    Then System show product details

  Scenario: Should add item to cart when click on add to cart on product details
    Given Open homepage
    When Search dress using search box
    And Click on product
    And Click on add to cart button
    Then Product is added to cart

