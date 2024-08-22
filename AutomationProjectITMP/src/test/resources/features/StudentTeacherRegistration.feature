Feature: Student/Teacher Registration on CollabToolz

  Scenario Outline: Registration on CollabToolz as a student
#    Given I am on the home page with login details "collaborationtool" "6Bzbqp3ckbupVfrw"
    Given I am on the home page with login details username "collaborationtool" password "6Bzbqp3ckbupVfrw"
#    When I select the login button
    And I click on the student teacher registration button
    And I select account type as "<accountType>"
    And I fill in first name as "<firstName>" and last name as "<lastName>"
    And I enter date of birth as "<dob>"
    And I select gender as "<gender>"
    And I enter uni email address "<emailAddress>"
    And I enter password as "<password>" and confirm password as "<password>"
    And I enter mobile number "<mobileNumber>"
    And I click on the next button
    And I fill out my academia details with "<academicLevel>" "<courseLength>" "<academicYear>" "<startDate>" "<grade>"
    And I click on the next button
    And I fill out other information section with industrial sector as "Consulting & Corporate Strategy" "Food & Hospitality"

    Examples:
      | accountType | firstName | lastName | dob        | gender | emailAddress          | password     | mobileNumber | academicLevel              | courseLength | academicYear | startDate  | grade              |
      | Student     | Oyin      | Odukudu  | 23/01/1998 | Female | ooduku200+1@gcu.ac.uk | FLowJam_2008 | 07471898345  | Dual Honours Undergraduate | 4 years      | Year 3       | 09/09/2020 | Upper Second Class |
