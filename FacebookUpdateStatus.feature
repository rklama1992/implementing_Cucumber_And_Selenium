Feature: Facebook status scenario

   Scenario: Update the facebook status
   Given Open chrome and start facebook application
   When I enter valid username and valid password to login
   Then User should be able to login and update status successfully