Feature: Existing user can login if his password and login are correct
	Existing user receives error notification if his password or login is not correct
	Logged in user receives success notification after login
	Logged in user sees "Hi, username" greating.

Scenario: user enters CORRECT login and password
	Given User navigates to url https://www.routeperfect.com/
	When User clicks Login link
	And User enters CORRECT login www@www.com and password www111www
	Then He sees "Hi, user name" greating
	
Scenario: user enters WRONG login and password
	Given User navigates to url https://www.routeperfect.com/
	When User clicks Login link
	And User enters WRONG login www@www.com and password www222www
	Then He sees ERROR notification	
	
Scenario: user enters EMPTY login and password
	Given User navigates to url https://www.routeperfect.com/
	When User clicks Login link
	And User enters WRONG login   and password  
	Then He sees EMPTY notification		

