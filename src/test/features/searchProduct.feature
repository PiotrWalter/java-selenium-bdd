Feature: Search products using search box
  Scenario: Should find products while using search box
    Given Open homepage
    When Search item using search box <item>
    Then System show products on list according to searched item <item>



