Feature: shopping feature
  Scenario: Should place order when proceed through whole checkout
    Given Open as logged user using waltertest@gmail.com email and 123^%$QAZwer password
    When I buy random dress and pay by bank wire
    Then Order is complete and system show Your order on My Store is complete. message


