
Feature: Navigate

  Scenario Outline: Positive test validating loging and navigating between tabs
    Given Initialize the browser with chrome
    And Navigate to "https://login.salesforce.com/" Site
    When User enters username and password and logs in
    Then Click Flat Icon
    And Select service
    Then Navigates between all the tabs, click new button and cancel
		And Close the Browser
		
 Examples: 
 |application 			 
 |Service               
 


