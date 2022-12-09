Feature: Negative Login Test

  @negativeLogin
  Scenario Outline:
    Given User should be on the login page
    When User should input "<userEmail>" and "<password>"
    Then The warning message contains "<message>"



    Examples:
      | userEmail              | password      | message                                              |
      | Mustafa@gmail.com      | wrongPassword | Email address or password is incorrect. Please check |
      | wrongEmail             | 123456789     | Email address or password is incorrect. Please check |
      | Mustafa@gmail          | 123456789     | Email address or password is incorrect. Please check |
      | Mustafaaaaaa@gmail.com | 123456789     | Email address or password is incorrect. Please check |
      | tafa@gmail.com         | 123456789     | Email address or password is incorrect. Please check |
      | Mustafagmail.com       | 123456789     | Email address or password is incorrect. Please check |
      |                        | 123456789     | Please enter your email.                             |
      | Mustafa@gmail.com      |               | Please enter your password!                          |
      |                        |               | Please enter your password!                          |

