Feature: CollabToolz dashboard access with different account types

  Scenario Outline: Dashboard valid login
    Given I am on the home page with login details "collaborationtool" "6Bzbqp3ckbupVfrw"
    When I select the login button
    And I provide the credentials "<accountType>" "<emailAddress>" "<password>"
    Then I am able to access the dashboard

    Examples:
      | accountType | emailAddress         | password     |
      | Student     | ajokepetra@gmail.com | #Omolola0    |
      | Recruiter   | andynetcs@gmail.com  | London12     |
      | Landlord    | jfashtest@gmail.com  | Password123! |

  Scenario Outline: Error Validation on Dashboard login page
    Given I am on the home page with login details "collaborationtool" "6Bzbqp3ckbupVfrw"
    When I select the login button
    And I provide the credentials "<accountType>" "<emailAddress>" "<password>"
    Then a warning message pops up

    Examples:
      | accountType | emailAddress           | password      |
      | Student     | ajokepetra@gmail.com   | #Omolola01    |
      | Recruiter   | andynetcsweq@gmail.com | London12      |
      | Landlord    | jfashtestrt@gmail.com  | Password123k* |