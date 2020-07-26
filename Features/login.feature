Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email "admin@yourstore.com" and Password "admin"
	And Click on Login
	Then Page Title Display "Dashboard / nopCommerce administration"
	When user click on Logout link
	Then Page Title Display "Your store. Login"
	And close Browser
	
	
Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email "<email>" and Password "<password>"
	And Click on Login
	Then Page Title Display "Dashboard / nopCommerce administration"
	When user click on Logout link
	Then Page Title Display "Your store. Login"
	And close Browser
	
	Examples:
	|email | password |
	|admin@yourstore.com | admin |
	|admin1@yourstore.com | admin123 |
	