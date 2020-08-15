Feature: Social Media Testing
  Background:
    Given Navigate to the website
    When I use legit username and password
    Then I am logged in
  Scenario: Succesfuly navigate to following pages
    When  Succesfuly navigate to following pages and verify
      | twitter    | twitter  |
      | googleplus | google   |
      | youtube    | youtube  |
      | facebook   | facebook |
