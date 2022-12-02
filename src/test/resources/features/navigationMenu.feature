@task
Feature: Task

  @1
  Scenario: Login as Mike
    Given The user is on the Login page
    When  At first get the text of dashboard
    Then  go to Developers menu and get the text of Developer

    @2
  Scenario: Login as Sebastian
    Given The user is on the Login page
    When  Get the text of dashboard
    Then  go to Edit Profile menu and get the text of Edit User Profile

   @3
   Scenario: Login as Jhon Nash
     Given The user is on the Login page
     When  Get the text of dashboard
     Then  go to My Profile menu and get the text of User Profile