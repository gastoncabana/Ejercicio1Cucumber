Feature: Navigate

  Background: User logged in
    Given Initialize the browser with chrome
    And Navigate to "https://login.salesforce.com/" Site
    When User enters username and password and logs in
    Then Click Flat Icon
    And Select service

  Scenario: "1" -  Positive test validating loging and navigating between tabs
    Given Navigates between all the tabs, click new button and cancel
    And Close the Browser

  Scenario: "2" -  Create new account record
    Given user  Navigates to accounts and click New
    Then Fill inputs information
    And fill combos Information
    And scrolls Down
    Then fill Addres information Inputs
    And fill Additional Address Information Combo
    And selects calendar day
    Then creates the Account Record
    And Close the Browser

  Scenario: "3" - Check error while creating new Account Record
    Given user  Navigates to accounts and click New
    Then try to creates new Account record without filling required input
    And waits expected error
    And Close the Browser after error

  Scenario: "4"- Create contact record in other tab
    Given user open contacts in a new tab
    Then fill Contact inputs
    And select Account Name
    Then fill  Contact combos
    And scrolls Down
    Then fill contact address information Inputs
    And fill additional contact address information
    And fill additional contact address information combo
    Then creates the Contact Record
    And returns to Home page
    And Close the Browser
    

  Scenario: "5"  - Compare  values from combobox Type, Rating & Upsell oportunity
    Given user  Navigates to accounts  clicks arrow and clicks edit
    Then clicks on each  Option , change it and saves
    And verify if options where changed
    And Close the Browser

  Scenario: "6" - Check error while creating new Account Record and save it
    Given user  Navigates to accounts  clicks arrow and clicks edit
    And change Employees value
    Then saves the change and saves error msg
    And Close the Browser

  
  Scenario Outline: Create different accounts
    Given user  Navigates to accounts and click New
    And user inputs <accountName> into Account Name Input, <employees> into Employees input, <accountSite> into Account Site input
    Then creates the Account Record
    And Close the Browser

    Examples: 
      | accountName | employees | accountSite     |
      | Cuenta1     | 099111111 | www.cuenta1.com |
      | Cuenta2     | 099222222 | www.cuenta2.com |
      #| Cuenta3     | 099333333 | www.cuenta3.com |
      #| Cuenta4     | 099444444 | www.cuenta4.com |
      #| Cuenta5     | 099555555 | www.cuenta5.com |
