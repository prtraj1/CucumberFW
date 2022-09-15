@LoginFunctionality
Feature: Login Functionality

  Background:
    Given User is on login page

  @ValidLogin
  Scenario Outline: User must be able to login using valid credentials
    When User enters username as <userName>
    And User enters password as <password>
    And User clicks on Login button
    Then User must be present inside homepage

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  @InvalidLogin
  Scenario Outline: User must not be able to login using invalid credentials
    When User enters username as <userName>
    And User enters password as <password>
    And User clicks on Login button
    Then User must be present inside login page

    Examples:
      | userName        | password     |
      | locked_out_user | secret_sauce |
      | standard_user   | not_secret   |