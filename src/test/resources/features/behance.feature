Feature: Checking a few functions of Behance

  Background: logging in Behance profile
    Given The user is on homepage
    And The user clicks on Sign in button
    When The user enters valid credentials "natalkapoltavka950@gmail.com" and "Social6039"
    And The user unchecks the check box - Stay signed in - and clicks on Sign In button
    Then The user is logged in

  Scenario: Moving to the profile page via popUp
    Given The user is on homepage
    When The user clicks on submenu element "Behance Profile"
    Then the user is on selected page

  Scenario: Uploading a Banner image
    Given The user is on homepage
    When The user clicks on submenu element "Behance Profile"
    Then the user is on selected page
    When the user clicks on Add Banner Image Button and selects image
      | banner1.jpg |
    And the user clicks on Done button
    Then the picture is uploaded

  Scenario Outline: Search with filters
    Given The user is on homepage
    When The user clicks on Search and Filter button
    Then the user is on the search page
    When The user clicks on the Additional Filters button
    And the user clicks on Tools Used button
    And the user clicks on "<tool>" button
    Then a new filter "<tool>" has appeared on filters menu
    Examples:
      | tool                      |
      | Adobe Photoshop           |
      | Adobe Illustrator         |
      | Adobe InDesign            |
      | Adobe After Effects       |
      | Adobe Photoshop Lightroom |

