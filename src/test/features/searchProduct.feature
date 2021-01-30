Feature: Search products using search box
  Scenario Outline: Should show correct item count
    Given Open homepage
    When Search <item> using search box
    Then System show correct item count <number of results>
    Examples:
      | item  |number of results         |
      |dress  |7 results have been found.|
      |t-shirt|1 result has been found.  |
      |blouse |1 result has been found.  |
      |ball   |0 results have been found.|
      |ball   |1 result has been found.  |

  Scenario: Should find products according to searched phrase
    Given Open homepage
    When Search dress using search box
    Then System show 7 results

