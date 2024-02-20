Feature: Login Page Aplikasi Kasir Aja
  Scenario : Success Login
    Given Halaman login kasir aja
    When input username
    And Input Password
    And Click login button
    Then User on dashboard page
