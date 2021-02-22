Feature: Library app login feature

  Scenario: Login page title

  Scenario: Login as librarian 16
    Given I am on the login page
    And Page title should be "Login - Library"
    When I enter username "librarian16@library"
    And I enter password "8BzUhhaU"
    And I click sign in button
    Then dashboard should be displayed
    And there should be 2951 user



  Scenario: Login as student 16
    Given I am on the login page
    When I enter username "student70@library"
    And I enter password "FPEDLRY3"
    And I click sign in button
    Then books should be displayed

