Feature: Job search functionality on NHS Jobs site

  As a jobseeker
  I want to search for jobs based on my preferences
  So that I can find recently posted job listings

Scenario: Search for jobs and sort by newest
    Given I am on the NHS Jobs search page
    When I enter preferences like "Testing" in the keywords and "London" in location
    And I click on the search button
    Then I should see a list of job results
    And the results should be sorted by "Date posted (newest)"
    Then I print the top job posting date
    
    
Scenario Outline: NHS Jobs search compatibility
  Given I open NHS Jobs site on "<browser>" browser
  When I enter preferences like "Testing" in the keywords and "London" in location
  And I click on the search button
  Then I should see a list of job results

Examples:

  | browser |   
  | chrome  | 
  | firefox |
  
    

