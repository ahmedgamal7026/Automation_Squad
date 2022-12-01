Feature: Feature to test Login Functionality

  Scenario Outline: check login is successfull with valid Data
 
    
Given user is on login page
When the user fills the username and password and clicks on the login button
|Admin|admin123|
Then user is navigated to the Home Page
