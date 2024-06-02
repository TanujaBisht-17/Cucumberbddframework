
Feature: Add Customers

Background: Repeated steps for Dashboard
Given User Launch chrome Browser 
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "admin@yourstore.com" and password "admin"
    And Click Login button 
    Then User can view Dashboard
    When User clicks customers Menu 
    And customers menu item 
    
@sanity 
  Scenario: Add a new Customer
   
    And User click Add new button
    Then User can view Add new customer page
    When User enter details in Add a new customer 
    And clicks Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser
    
 @sanity @regression   
   Scenario: Search customer by email
    And User enters email
    When User clicks search button
    Then User found email in search table
    And close browser
    
 @regression   
    Scenario: Search customer by name
    And User enters first name
    And User enters Last name
    When User clicks search button
    Then User found name in search table 
    And close browser
    
    


  

    
