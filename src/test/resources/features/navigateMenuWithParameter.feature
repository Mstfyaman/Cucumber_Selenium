Feature: Navigate to menu with parameter

@rerun
  Scenario: Mustafa navigates to edit profile
    Given User should be on the login page
    When User should input "Mustafa@gmail.com" and "123456789"
    Then The user name should be "Mustafa"
    When The user navigates to "Edit Profile" menu
    Then The user should be able to see home name as "Edit User Profile"
  @rerun
  Scenario: Eddie Murphy navigates to Developers menu
    Given User should be on the login page
    When User should input "eddiem@kraft.com" and "eddiem12"
    Then The user name should be "Eddie Murphy"
    When The user navigates to "Developers" menu
    Then The user should be able to see home name as "Developers"

  @rerun
  Scenario: Morgan Freeman navigates to Dashboard menu
    Given User should be on the login page
    When User should input "morganfreeman@kraft.com" and "mfreeman"
    Then The user name should be "Morgan Freeman"
    When The user navigates to "Dashboard" menu
    Then The user should be able to see home name as "Dashboard"


  Scenario Outline: Diffrent user <name>  navigates to <tab> menu
    Given User should be on the login page
    When User should input "<userEmail>" and "<password>"
    Then The user name should be "<name>"
    When The user navigates to "<tab>" menu
    Then The user should be able to see home name as "<home name>"

    Examples:
      | userEmail               | password  | name           | tab          | home name         |
      | Mustafa@gmail.com       | 123456789 | Mustafa        | Edit Profile | Edit User Profile |
      | eddiem@kraft.com        | eddiem12  | Eddie Murphy   | Developers   | Developers        |
      | morganfreeman@kraft.com | mfreeman  | Morgan Freeman | Dashboard    | Dashboard         |
