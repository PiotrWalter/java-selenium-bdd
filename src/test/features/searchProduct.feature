Feature: Search products using search box
  Scenario Outline: Should find products while using search box
    Given Open homepage
    When Search <item> using search box
    Then System show products on list and accordingly <number of results>
    Examples:
      | item  |number of results         |
      |dress  |7 results have been found.|
      |t-shirt|1 result has been found.  |
      |blouse |1 result has been found.  |
      |ball   |0 results have been found.|



