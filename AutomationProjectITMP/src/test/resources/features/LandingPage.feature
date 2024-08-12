Feature: Validation on collabtool landing page

  Scenario Outline: Landing Page Login Validation - Invalid scenario
    Given I nagivate to the collabtool url
    When I enter the username "<username>"
    And I enter the password "<password>"
    And I click the submit button on the landing page
    Then a warning message is displayed "Invalid username or password."

    Examples:
      | username            | password         |
      | collaborationtool   | 6BzbqpkbupVfrw   |
      | collaborationtoolzz | 6Bzbqp3ckbupVfrw |
      | collaboration       | 6Bzp3ckbupVfr    |

