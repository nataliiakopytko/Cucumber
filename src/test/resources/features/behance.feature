Feature: Checking a few functions of Behance

  Scenario Outline: Logging in to behance.net
    Given The user is on homepage
    And The user clicks on Sign in button
    When The user enters valid credentials "<username>" and "<password>"
    And The user unchecks the check box - Stay signed in - and clicks on Sign In button
    Then The user is logged in
    Examples:
      | username                     | password   |
      | natalkapoltavka950@gmail.com | Social6039 |