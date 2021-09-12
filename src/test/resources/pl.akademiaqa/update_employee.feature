Feature: Update employee data

  Scenario: I should be able to update employee email
    Given Employee already exist
    When I update employee email
    Then I could see updated employee email