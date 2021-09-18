Feature: Delete existing bug

  Scenario: I am able to delete existing bug
    Given bug already exist
    When I delete existing bug
    Then I should not see deleted bug on bug list
