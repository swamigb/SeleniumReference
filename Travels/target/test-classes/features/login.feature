Feature: Login feature

Scenario: Login with correct credentials
Given User opens the browser
And User navigates to "url"
When User navigates to login page
And User enters "user@phptravels.com" and "demouser"
And User clicks on "Login" button
Then User lands on profile is "Success"
And Close the browser




Scenario Outline: Login with multiple credentials
Given User opens the browser
And User navigates to "url"
When User navigates to login page
And User enters <UserName> and <Password>
And User clicks on "Login" button
Then User lands on profile is "Success"
And Close the browser

Examples:
|UserName	|Password	|
|user@phptravels.com|demouser|
|user@php.com|demopwd|
