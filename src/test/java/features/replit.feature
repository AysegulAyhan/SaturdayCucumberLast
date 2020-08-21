Feature: Control of List  Feature Test
Background:
  Given Navigate to the "weborders" and enter your credentials

  Scenario: Verify 8 items on page
    Given I am logged in and verify eight items

  Scenario: Succesfuly created order and verified steps
    Given Fill  out form
    And Find this order in order list
    Then Verify the list count is increased
