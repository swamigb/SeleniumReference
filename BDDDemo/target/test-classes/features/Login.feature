Feature: Verify login functionality

Scenario: Login with valid credentials
Given User is on home page
When User clicks on login button
And User enters user name and password
Then User should see profile screen
