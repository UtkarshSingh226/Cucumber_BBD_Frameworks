# Adding Smoke Test to check LoGinPage and HomePage features 
@SmokeTest 
Feature: Amazon HomePage and LoginPage

  Background: 
    Given browser is open


  Scenario: Login as a valid user for Product Search
    Given User navigates to the Amazon homepage with the URL "https://www.amazon.in/"
    When User clicks on SignIn
    And User enters email "UtkarshSingh0126932@gmail.com"
    And User clicks on Continue
    And User enters password "test@26932"
    Then User is navigated to Amazon Home Page

  Scenario Outline: Search for a product on Amazon
    And User is on the Amazon home page 
    And User searches for <productName>
    Then User should see search results for <productName>
    Examples: 
    | productName |
    | BasketBall |
    | Laptop |
    | PowerBank|
    
