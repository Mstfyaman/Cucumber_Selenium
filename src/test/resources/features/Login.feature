
@login
Feature: Krafttech Log in Test

  # Agile story : As a user, I should be able to Log in so I can see my account

  @Mike @smoke @SDET
  Scenario: Login as Mike
    Given The user is on the Login page
    When The user enters Mike credentials
    Then The user should be able to login

  @Sebastian @smoke @QA
  Scenario: Login as Sebastian
    Given The user is on the Login page
    When The user enters Sebastian credentials
    Then The user should be able to login

    # class task user enters Jhon Nash credential 3 minutes

 @developer @db
  Scenario: Login as Jhon Nash
    Given The user is on the Login page
    When The user enters Jhon Nash credentials
    Then The user should be able to login

  @developer @smoke
  Scenario: Login as Rosa
    Given The user is on the Login page
    When The user enters Rosa credentials
    Then The user should be able to login


  Scenario: User should be able to login with valid credentials
    Given User should be on the login page
    When User should input login information
    Then User should be on home page

  @wip
  Scenario: Login with parameters
    Given User should be on the login page
    When User should input "user11@test.com" and "Test123456"
    Then User should be on home page