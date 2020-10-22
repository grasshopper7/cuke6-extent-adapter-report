@tabledoc
Feature: DataTable And DocString
  DataTable And DocString Description

  Background: 
    Given 'Hello' background

  @datatable
  Scenario: DataTable Scenario
    Given Customer orders the dishes
      | dish            | quantity |
      | Spicy Meatballs |        2 |
      | Fried Gnocchi   |        2 |
      | Espresso        |        3 |

  @docstring
  Scenario: Doc String to Custom Object
    Given the doc string is
      """
      Hello there how r u?
      
      Doing great.
      Whats new?
      
      Nothing much.
      """
