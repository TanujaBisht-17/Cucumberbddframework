
Feature: Add Customers

  Scenario: Add a new Customer
   Given User Launch chrome Browser 
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "admin@yourstore.com" and password "admin"
    And Click Login button 
    Then User can view Dashboard
    When User clicks customers Menu Item
    And customers menu item 
    And User click Add new button
    Then User can view Add new customer page
    When User enter details in Add a new customer 
    And clicks Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser
    
    


  

    
