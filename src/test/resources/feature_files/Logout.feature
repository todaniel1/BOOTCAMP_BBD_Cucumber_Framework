@TutorialsNinjaLogout
Feature: Logout functionality of Tutorialsninja 

  As a user actively engaged with TutorialsNinja,
  I desire the capability to sign out of my account
  In order to safeguard the security of my account during periods of inactivity on the site.

  Scenario Outline: Successful logout of the application
    Given I am logged into the TutorialsNinja website with email "seleniumpanda@gmail.com" and password "Selenium@123"
    When I click on the logout option
    Then I should be logged out of the system
    
   

  

