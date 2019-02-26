Feature: feature name

  Scenario: Looking up the translation of 'apple'
    Given the user is on the google translate page
    Given selected languages from english to ukrainian
    When the user looks up the translation of the word "apple"
    Then they should see the translation "яблуко"

  Scenario: Check the number of characters entered
    Given the user is on the google translate page
    Given selected languages from english to ukrainian
    When the user looks up the translation of the word "apple"
    Then the number of characters must be "6"

  Scenario: Looking up the definition of 'apple'
    Given the user is on the google translate page
    Given selected languages from english to ukrainian
    When the user looks up the translation of the word "apple"
    Then they should see the definition "the tree which bears apples."