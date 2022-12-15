
  Feature: Profile Test

    Background:
      Given User should be on the login page

    @parallel
    Scenario: User should be able to edit profile
      When User should input login information
      And User should go to My profile
      And User should navigate to "Edit Profile"
      And User should input the information boxes
      Then User should verify the profile updated message


      Scenario: User should be able to see profile options
        When User should input "user11@test.com" and "Test123456"
        Then User should see he profile options
        |Components|
        |Forms    |
        |JavaScript|
        |My Profile|