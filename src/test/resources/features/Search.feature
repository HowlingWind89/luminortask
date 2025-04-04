Feature: Search

  @Luminor
  Scenario: Search QA on main page
    When I accept cookie banner
    And I enter QA in to search field
    And I click on the first movie in the list
    Then Movie Avengers: Doomsday page is opened
    And 5 names of top cast is printed to console