Feature: Create new task

  Scenario: The user can add a new task
    Given Click Add new Task
    Given Enter TaskName
    Given enter TaskNote
    When Click Save
    Then Task added successfully