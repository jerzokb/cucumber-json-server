Feature: Update bug

  Scenario: I am able to close bug
    Given bug already exist
    When I close existing bug
    Then I can read updated bug and see status as closed