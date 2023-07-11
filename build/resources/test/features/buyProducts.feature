Feature: Buy a list of products in Exito web page

  Scenario: buyProducts in exito
    Given user buys 5 products of "categorie"
    When sees the cart
    Then should see the price of the products
    And should see the quantities of the products