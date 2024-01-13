Feature: Bincang QA Test
  Scenario: Login succes on sausdemo
    Given open web url "https://www.saucedemo.com"
    And Input username "standard_user" and password "secret_sauce"
    When Click login button
    Then Should success and redirected to homepage

  Scenario Outline: Failed login and showing message
    Given open web url <url>
    And Input username <username> and password <password>
    When Click login button
    Then Should showing error message
    Examples:
      | url                         | username        | password       |
      | "https://www.saucedemo.com" | "standard_user" | "haniayaaa" |