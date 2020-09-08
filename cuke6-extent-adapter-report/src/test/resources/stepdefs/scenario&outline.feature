@both
Feature: Scenario And Scenario Outline
  Scenario And Scenario Outline Description

	@sout
  Scenario Outline: Scenario Outline Row <row_num>
    Scenario Outline Description

    Given Write a 'given' step with precondition in '<scenario_num><row_num>'
    When Complete action in 'when' step in '<scenario_num><row_num>'
    Then Validate the outcome in 'then' step in '<scenario_num><row_num>'

		@soodd
    Examples: Odd number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     300 |
      | Scenario Outline Two |     500 |

		@soeven
    Examples: Even number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     400 |
      | Scenario Outline Two |     600 |

	@scen
  Scenario: Scenario Number Seven Seven Seven
    Scenario Description

    Given Write a 'given' step with precondition in 'Scenario 777'
    When Complete action in 'when' step in 'Scenario 777'
    Then Validate the outcome in 'then' step in 'Scenario 777'
