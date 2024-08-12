Feature: Registration on LambdaTest Website

  Background:
    Given I navigate to the form demo website

  @valid @oyin
  Scenario: Valid form registration
#    Given I navigate to the form demo website
    When I enter my name
    And I enter a valid email address
    And I enter a valid password
    And I enter my company name
    And I enter my website url
    And I select country from the dropdown list
    And I enter my city
    And I enter my address
    And I enter the second line of my address
    And I enter my state
    And I enter my zip code
    And I click the submit button
    Then the form is submitted successfully

  @valid
  Scenario Outline: Valid form registration with examples
#    Given I navigate to the form demo website
    When I enter my name "<fullName>"
    And I enter an email address "<emailAddress>"
    And I enter a valid password "<password>"
    And I enter my company name
    And I enter my website url "<website>"
    And I select country from the dropdown list
    And I enter my city "<city>"
    And I enter my address
    And I enter the second line of my address
    And I enter my state
    And I enter my zip code "<zipCode>"
    And I click the submit button
    Then the form is submitted successfully

    Examples:
      | fullName     | emailAddress       | password         | website                                            | city       | zipCode  |
      | Tanis Janis  | tanisJan@gmail.com | agdh263hjn_      | https://www.linkedin.com/in/oluwaseun-odukuduoy12/ | Edinburgh  | EH12 9LD |
      | Jen Davis    | jendavis@gmail.com | uwjfj_635hkdl    | https://www.linkedin.com/in/oluwaseun-odukuduoy13/ | London     | SW23 6GH |
      | Yan Lee      | yanlee@gmail.com   | lqoeujf!738rjmky | https://www.linkedin.com/in/oluwaseun-odukuduoy14/ | Manchester | M12 7YH  |

  @invalid1
  Scenario: Invalid form registration around name field
#    Given I navigate to the form demo website
    When I omit my name
    And I enter a valid email address
    And I enter a valid password
    And I enter my company name
    And I enter my website url
    And I select country from the dropdown list
    And I enter my city
    And I enter my address
    And I enter the second line of my address
    And I enter my state
    And I enter my zip code
    And I click the submit button
    Then a warning prompt is displayed

  @invalid
  Scenario: Invalid form registration around email field
#    Given I navigate to the form demo website
    When I enter my name
    And I enter an email address "ogann"
    And I enter a valid password
    And I enter my company name
    And I enter my website url
    And I select country from the dropdown list
    And I enter my city
    And I enter my address
    And I enter the second line of my address
    And I enter my state
    And I enter my zip code
    And I click the submit button
    Then a warning prompt is displayed