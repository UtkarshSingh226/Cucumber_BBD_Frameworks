# Adding Regression Test tag to check features of different Amazon Pages 
@RegressionTest
Feature: Amazon MiniTv Page and AddToCart Page

  Background: 
    Given now Chrome is Open
    Given user navigates to Amazon homepage with URL "https://www.amazon.in/"


  Scenario: Navigating to Amazon MiniTv Page
    When user clicks on Amazon MiniTv tab
    Then user navigates to Amazon MiniTv

 
  Scenario: Adding Item to Amazon Cart Page 
    When user search for the productName "Iphone 15"
    And user click on add to cart
    And product is sucessfully added
    Then user navigated to amazon cart
