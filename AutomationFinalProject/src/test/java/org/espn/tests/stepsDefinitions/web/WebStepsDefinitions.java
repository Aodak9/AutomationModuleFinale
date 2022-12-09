package org.espn.tests.stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.reporting.Reporter;
import org.espn.showable.pages.*;
import org.testng.Assert;

public class WebStepsDefinitions {

    private NavigationBar navigationBar;
    private OptionsForUser optionsForUser;
    private LoginIframe loginIframe;
    private SignUpIframe signUpIframe;
    private WatchPage watchPage;
    private static String EMAIL = "hormiguitatest-0-@gmail.com";

    public void setEmail(){
        int randomValue = (int) (Math.random() * 5000);
        EMAIL = "Hormiguitatest-" + randomValue + "-@gmail.com";
    }

    @Given("User open the ESPN website")
    public void user_open_the_espn_website() {
        this.navigationBar = new NavigationBar(WebHooks.getDriver());
    }


    @When("User completes the sign up form {string} {string} {string}")
    public void userCompletesTheSignUpForm(String name, String lastname, String password) {
      optionsForUser = navigationBar.goToOptionsForUser();
      loginIframe = optionsForUser.clickLoginButton();

      Reporter.info("Verify login modal and components are displayed");
      Assert.assertTrue(loginIframe.areLoginFormElementsDisplayed(), "Log in modal and components are not displayed");

      signUpIframe = loginIframe.clickSignUpButton();
      Reporter.info("Verify sign up components are displayed");
      Assert.assertTrue(signUpIframe.areSignUpFormElementsDisplayed(), "Sign up components are not displayed");

      setEmail();
      signUpIframe.completeInformationForSignUp(name, lastname, EMAIL, password);
      signUpIframe.clickToConfirmSignUpButton();
      Reporter.info("Email of new user: " + EMAIL);
    }

    @And("User goes to the watch page")
    public void userGoesToTheWatchPage() {
        Reporter.info("goes to: Watch page");
        watchPage = navigationBar.goToWatchPage();
    }

    @Then("Watch page must be displayed")
    public void watchPageMustBeDisplayed() {
        Reporter.info("Verify watch page components are displayed");
        Assert.assertTrue(watchPage.areWatchPageElementsDisplayed(), "Watch page is not displayed");

        Reporter.info("Verify title is present in each carousel card");
        Assert.assertTrue(watchPage.carouselsCardTitleDisplayed(), "Title cards are not displayed");

        watchPage.clickCarouselCard(1);
        Reporter.info("Verify choose supplier frame is present");
        Assert.assertTrue(watchPage.ExitChooseSupplierButtonDisplayed(), "Choose supplier frame is not displayed");
        watchPage.clickExitFromChooseSupplier();
    }

    @And("User go back to home page, this one still supposed to be connected {string}")
    public void userGoBackToHomePageThisOneStillSupposedToBeConnected(String name) {
        Reporter.info("goes to: home page");
        watchPage.goToPreviousPage();

        optionsForUser = navigationBar.goToOptionsForUser();
        Reporter.info("Verify user still connected");
        Assert.assertEquals(optionsForUser.getUsernameLogged(), (name + "!"), "User is not connected");
    }

    @And("User logs out from session")
    public void userLogsOutFromSession() {
        Reporter.info("Log out");
        optionsForUser.clickLogoutButton();
        optionsForUser.reloadPage();

        optionsForUser = navigationBar.goToOptionsForUser();
        Reporter.info("Verify user is disconnected");
        Assert.assertTrue(optionsForUser.isUserLogout(), "User still connected");
    }
}
