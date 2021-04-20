Feature:

#  Scenario: User searches a product from Televizoare Resigilate
#    Given User opens eMAG home page
#    When User writes in the search field the product name and presses on cauta button
#    Then All products from televizoare are displayed
#    And User filters from disponibilitate products which are resigilate
#    Then Navigate on diagonala display of the first product
#    And Add the product to shopping basket
#    Then Check if the product is in the shopping basket
#    Then Delete the product from shopping basket
#    And User navigates to home page

  Scenario: User is on Home Page and searches for a list of products
    Given User opens eMAG home page
    When User searches for tastatura in search bar
    And User selects eMAG genius products
    Then User adds products to cart
#    Then User checks that the products are added to cart
#    And User deletes all the products from cart
#    Then User navigates to home page
#
#  Scenario: Adding the first 3 products in the cart depending on their ascending price
#    Given User opens eMAG home page
#    Then  User types in the search bar mouse
#    And User sorts a list of products in ascending order
#    When User adds the first three products to the cart
#    Then The three products should be in my shopping cart
#    And User deletes the products from the cart
#    Then User navigates to home page
#
#  Scenario: Sort a list of products in order to get the one with the most reviews
#    Given User opens eMAG home page
#    When User searches for a list of products in casti category
#    Then Show a list of casti products
#    When User filters the list based on reviews
#    Then Show a list of casti products ordered by most reviews
#    When User selects desired product to see his review
#    Then Show selected product page info
#    And Product review is displayed in console
#    Then User navigates to home page