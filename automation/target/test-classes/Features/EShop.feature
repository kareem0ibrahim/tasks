Feature: Add items to cart on eshop.vodafone.com.eg

  Scenario Outline: Add items to cart
    Given I am on the eshop.vodafone.com.eg homepage
    When I login "<username>" and password "<password>"
    And I select two items and add them to the cart
    And I search for an item and add it to the cart
    Then I should see three items in the cart

    Examples: 
      | username    | password        |
      | 01111450166 | Vodaphone@task1 |
