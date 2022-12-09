@webAutomation
  Feature: ESPN functionality
    As a user I want to check different functionalities in the ESPN Website
    I want to log in successfully and go through the website

    @webAutomation
    Scenario Outline: As a valid user, navigation through the website home page and watch page is possible
      Given User open the ESPN website
      When User completes the sign up form "<name>" "<lastname>" "<password>"
      And User goes to the watch page
      Then Watch page must be displayed
      And User go back to home page, this one still supposed to be connected "<name>"
      And User logs out from session
    Examples:
      | name    | lastname     | password   |
      | hormiga | hormiga-smith| hormiga123*|


