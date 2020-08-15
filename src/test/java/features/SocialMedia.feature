Feature: Social Media Testing
  Background:
    Given Navigate to the website
    When I use legit username and password
    Then I am logged in
Scenario: Succesfuly navigate to Facebook Page
  When Click on Facebook icon
  Then Appears Facebok login page
  Scenario: Succesfuly navigate to Twitter
    When Click on Twitter icon
    Then Appears Twitter login page
  Scenario: Succesfuly navigate to Youtube
    When Click on YouTube icon
    Then Appears YouTube login page
  Scenario: Succesfuly navigate to GooglePlus
    When Click on GooglePlus icon
    Then Appears GooglePlus login page