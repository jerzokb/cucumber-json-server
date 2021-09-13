Feature: Create bug

  Scenario: I am able to create multiple bugs
    Given I read all bugs
    When I create multiple bugs
      | title        | description           | employeeId | status |
      | Sample title | This is not a bug     | 2          | open   |
      | Super title  | This is huge issue    | 1          | open   |
      | Just a title | Some description here | 3          | open   |
    Then I see created bugs on bugs list