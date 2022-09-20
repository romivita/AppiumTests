Feature: Create new task

  Scenario Outline: The user can add a new task
    Given Click Add new Task
    Given Enter "<TaskName>" and "<TaskNote>"
    Then Task added successfully

    Examples:
      | TaskName        | TaskNote    |
      | Cucumber Task 1 | Task 1 Note |
      | Cucumber Task 2 | Task 2 Note |
