Feature: Create new employee

  Scenario: I am able to create new employee
    Given I read all employees
    When I create new employee
    Then I see created employee on employees list