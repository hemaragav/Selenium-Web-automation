Feature: Login to SaleseForce Application

Scenario: Login with Positive Data

Given Launch the browser and load the URL

When Enter the username as "dilip@testleaf.com"
And Enter the password as "testleaf@2024"
And Click the LoginButton
Then Verify its in HomePage
And Click on toggle menu button from the left corner
And Click view All and click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter your name as account name as "Hema"
And Select Ownership as Public
And Click Save
Then Verify Account name matches with Toast message



