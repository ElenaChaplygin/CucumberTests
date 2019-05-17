Feature: Existing user can login if his password and login are correct
Existing user receives error notification if his password or login is not correct
Logged in user receives success notification after login
Logged in user sees "Hi, username" greating.

Scenario: user enters correct login and password

Given User clicks "Login" link

When User enters correct login and password

Then He sees "Hi, user name" greating

