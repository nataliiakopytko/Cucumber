Feature: Checking Google Translate functions

  Scenario Outline: Looking up the translation of 'apple'
    Given the user is on the google translate page
    And selected languages from english to ukrainian
    When the user looks up the translation of the word "<word>"
    Then they should see the translation "<translation>"
    Examples:
      | word  | translation |
      | apple | яблуко      |
      | cup   | чашки       |
      | dog   | собака      |

  Scenario Outline: Check the number of characters entered
    Given the user is on the google translate page
    And selected languages from english to ukrainian
    When the user looks up the translation of the word "<word>"
    Then the number of characters must be "<number>"
    Examples:
      | word  | number |
      | apple | 6      |
      | cup   | 5      |
      | dog   | 6      |

  Scenario Outline: Looking up the definition of 'apple'
    Given the user is on the google translate page
    And selected languages from english to ukrainian
    When the user looks up the translation of the word "<word>"
    Then they should see the definition "<definition>"
    Examples:
      | word  | definition                                                                          |
      | apple | the tree which bears apples.                                                        |
      | cup   | a cup-shaped thing.                                                                 |
      | dog   | a person regarded as unpleasant, contemptible, or wicked (used as a term of abuse). |
