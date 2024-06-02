
Feature: Verify Login Functionality
@sumil
  Scenario: Successful Login with valid credentials
    Given User Launch chrome Browser 
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "admin@yourstore.com" and password "admin"
    And Click Login button 
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login" 
    And close browser
    
 @regression   
 Scenario Outline: Successful Login with valid credentials ddt
    Given User Launch chrome Browser 
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "<email>" and password "<password>"
    And Click Login button 
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login" 
    And close browser
    
    
Examples: 
      | email  | password |
      | admin@yourstore.com|admin |
      | test@yourstore.com|admin |
      
     