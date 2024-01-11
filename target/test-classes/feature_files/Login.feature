@TutorialsNinjaLogin
Feature: Login functionality of TutorialsNinja


@ValidCredentials
Scenario Outline: User is expected to be on logout page
Given User navigates to LoginPage
When User enters valid email <email> into email textbox field
And User enters valid password <password> into password textbox field
And User clicks on Login button
Then User is navigated to AccountPage
Examples:

|          email 				    | password 		 |
| seleniumpanda@gmail.com   | Selenium@123 |
| seleniumpanda1@gmail.com  | Selenium@123 |
| seleniumpanda2@gmail.com  | Selenium@123 |
| seleniumpanda3@gmail.com  | Selenium@123 |
| seleniumpanda4@gmail.com  | Selenium@123 |
| seleniumpanda5@gmail.com  | Selenium@123 |
| seleniumpanda6@gmail.com  | Selenium@123 |
| seleniumpanda7@gmail.com  | Selenium@123 |
| seleniumpanda8@gmail.com  | Selenium@123 |
| seleniumpanda9@gmail.com  | Selenium@123 |
| seleniumpanda10@gmail.com | Selenium@123 |


@InvalidCredentials
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters invalid email into email textbox field
And User enters invalid password 'Selenium@123456' into password textbox field
And User clicks on Login button
Then User gets warning message about credentials mismatch


@ValidEmailInvalidPassword
Scenario: Login with valid email and invalid password
Given User navigates to LoginPage
When User enters valid email 'seleniumpanda@gmail.com' into email textbox field
And User enters invalid password 'Selenium@123456' into password textbox field
And User clicks on Login button
Then User gets warning message about credentials mismatch


@InvalidEmailValidPassword
Scenario: Login with invalid email and valid password
Given User navigates to LoginPage
When User enters invalid email into email textbox field
And User enters valid password 'Selenium@123' into password textbox field
And User clicks on Login button
Then User gets warning message about credentials mismatch


@NoCredentials
Scenario: Login without credential
Given User navigates to LoginPage
And User clicks on Login button
Then User gets warning message about credentials mismatch

