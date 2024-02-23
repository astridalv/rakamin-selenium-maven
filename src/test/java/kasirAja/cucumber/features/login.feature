Feature: Login Success

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login kasir aja
    When input username
    And Input Password
    And Click login button
    Then User on dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login kasir aja
    When input username
    And Input invalid Password
    And Click login button
    Then User get error message

  @TDD
  Scenario Outline: User login to kasir aja
    Given Halaman login kasir aja
    When i input <email> as email
    And i input <password> as password
    And click login button
    Then i verify <status> login result

    Examples:
      | email                    | password | status |
      | tdd-selenium@gmail.com   | tdd-selenium | success |
      | failed-login@gmail.com   | failed-login | failed  |


