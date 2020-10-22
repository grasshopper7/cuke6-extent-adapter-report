@exception
Feature: Exception

  Scenario: Exception
    Given Raise exception

  Scenario: No Exception
    Given Do not raise exception

  Scenario: Other Exception
    Given Raise exception
    Given Raise exception

  Scenario Outline: Check exception
    Given Raise exception

    Examples: 
      | row_num |
      |       1 |
      |       2 |
