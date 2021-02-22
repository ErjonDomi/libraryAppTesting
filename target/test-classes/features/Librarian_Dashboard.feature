Feature: Dashboard Page Feature


  Background:
    Given user has already logged in to application

  @dash
  Scenario: Dashboard page title
    Given user is on Dashboard page
    When user gets the URL of the page
    Then page URL should should be "http://library2.cybertekschool.com/#dashboard"

  @dash
  Scenario:Librarians  should have access to 3 modules
    Given user is on Dashboard page
    Then the user should see following modules
      | Dashboard |
      | Users     |
      | Books     |


