Feature: User searches for a different types of products on eMAG website

  Scenario Outline: Adding the first two products in the cart and delete them from the chart
    Given User opens eMAG home page
    And  User types <product> in the search bar
    And User adds the first two products to the cart
    When User delete all products from the cart
    Then The shopping cart must be empty
    And User navigates to home page and quit the browser
    Examples:
      |product|
      |iphone 12 pro|
      |bicicleta|
      |snowboard|
      |airmax|

  Scenario Outline: User is on Home Page and searches for a list of products
    Given User opens eMAG home page
    When User searches for <product> in search bar
    And User selects eMAG genius products
    Then User adds products to cart
    Then User checks that the products are added to cart
    And User deletes all the products from cart
    And User navigates to home page and quit the browser
    Examples:
      |product|
      |iphone 12|
      |samsung galaxy|

  Scenario Outline: Sort a list of products in order to get the one with the most reviews
    Given User opens eMAG home page
    When User searches for <product> in search box
    Then Show a list of casti products
    When User filters the list based on reviews
    And User selects desired product to see his review
    Then Show selected product page info
    And Product review is displayed in console
    And User navigates to home page and quit the browser
    Examples:
    |product|
    |casti|
    |Iphone 12 neverlock|

  Scenario Outline: User searches a product from Televizoare Resigilate
    Given User opens eMAG home page
    When User writes in the search field the <product> name and presses on cauta button
    Then All products from televizoare are displayed
    And User filters from disponibilitate products which are resigilate
    When Navigate on diagonala display of the first product
    And Add the product to shopping basket
    Then Check if the product is in the shopping basket
    Then Delete the product from shopping basket
    And User navigates to home page and quit the browser
    Examples:
      |product|
      |televizoare|
      |iphone 12 promax|

  Scenario Outline: Adding the first 3 products in the cart depending on their ascending price
    Given User opens eMAG home page
    And  User types in the search bar <product>
    And User sorts a list of products in ascending order
    When User adds the first three products to the cart
    Then The three products should be in my shopping cart
    When User delete the products from the cart
    Then The shopping cart must be empty
    And User navigates to home page and quit the browser
    Examples:
    |product|
    |mouse|
    |iphone 12 promax|



