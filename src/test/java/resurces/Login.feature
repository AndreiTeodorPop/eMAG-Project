Feature:
  Scenario: Login with valid credentials (email and password)
    Given User accesses eMAG website
    When User enters his email address and his password
    Then User succesfully login into his account
    And User goes on his account
    Then User updates his home address
    And User navigates on the main page