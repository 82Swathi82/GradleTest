Feature: Verify Google search
  Scenario: Search for book
    Given I open the Google url
    When I type "book"
    Then I should see links with books

  Scenario: Search for pen
    Given I open the Google url
    When I type "pen"
    Then I should see links with pens