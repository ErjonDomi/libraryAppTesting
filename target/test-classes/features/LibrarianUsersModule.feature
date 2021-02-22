Feature: Librarian  Users module
  Background:
    Given user has already logged in to application


  Scenario: Librarian UsersModule page title
    Given user clicks on on Users page
    When user gets the URL of the page
    Then page URL should be "http://library2.cybertekschool.com/#users"




  Scenario Outline:add users with all valid info
    Given the librarian is on the users page
    When  user  click add user
    And user enter Full Name "<fullName>"
    And user enter password "<password>"
    And user enter User Group "<userGroup>"
    And user enter Start Date "<startDate>"
    And user enter Email "<email>"
    And user enter Status "<status>"
    And user enter End Date "<endDate>"
    Then user click save changes
    Examples:
      | fullName  | password | userGroup | startDate  | email                | status   | endDate    |
      | John Doe  | pass123  | Librarian | 2021-02-21 | email123@hotmail.com | ACTIVE   | 2021-03-21 |
      | Alex User | abc456   | Students  | 2021-02-21 | alex123@hotmail.com  | INACTIVE | 2021-03-21 |



  Scenario Outline:add users with all valid info
    Given the librarian is on the users page
    When  user  click add user
    And user enter Full Name "<fullName>" and password "<password>" and User Group "<userGroup>" and Start Date "<startDate>" and  Email "<email>" and Status "<status>" and End Date "<endDate>"
    Then user click close
    Examples:
      | fullName  | password | userGroup | startDate  | email                | status   | endDate    |
      | John Doe  | pass123  | Librarian | 2021-02-21 | email123@hotmail.com | ACTIVE   | 2021-03-21 |
      | Alex User | abc456   | Students  | 2021-02-21 | alex123@hotmail.com  | INACTIVE | 2021-03-21 |



  Scenario Outline: Librarian should be able to edit user info
    Given the librarian is on the users page
    When librarian click edit user
    And librarian changes the  Full Name "<fullName>" and password "<password>" and User Group "<userGroup>" and Start Date "<startDate>" and  Email "<email>" and Status "<status>" and End Date "<endDate>"
    Then librarian saves the changes
    Examples:
      | fullName   | password | userGroup | startDate  | email                  | status   | endDate    |
      | Malcolm X  | pass123  | Librarian | 2021-02-21 | malcolm123@hotmail.com | ACTIVE   | 2021-03-21 |
      | Yousuf Abi | abc456   | Students  | 2021-02-21 | yousuf123@hotmail.com  | INACTIVE | 2021-03-21 |


  @wip
  Scenario: verify that the default record is 10
    Given the librarian is on the users page
    When librarian goes to  shows record
    Then librarian check the default record is "10"


  @wip
  Scenario Outline: Show records for count options
    Given the librarian is on the users page
    When librarian goes to  shows record
    Then librarian check the selected options are "<count>"

    Examples:
      | count |
      | 5     |
      | 10    |
      | 15    |
      | 50    |
      | 100   |