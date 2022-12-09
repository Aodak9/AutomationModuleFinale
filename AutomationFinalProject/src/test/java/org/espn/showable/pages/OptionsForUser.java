package org.espn.showable.pages;

import org.espn.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OptionsForUser extends WebOperations {
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "a[tref$='login']")
    private WebElement loginButton;

    @FindBy(css = "a[tref$='modifyAccount']")
    private WebElement espnProfileButton;

    @FindBy(css = "a[onclick*='logout']")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginPopUp;
    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public OptionsForUser(WebDriver driver) {
        super(driver);
    }

    public void switchToLogInIframe(){
        isElementDisplayed(loginPopUp);
        super.getDriver().switchTo().frame(loginPopUp);
    }

    public LoginIframe clickLoginButton(){
        clickElement(loginButton, 3);
        switchToLogInIframe();
        return new LoginIframe(getDriver());
    }

    public String getUsernameLogged() {
        if (isElementDisplayed(userLabelOnline)) {
            return userLabelOnline.getText();
        }
        return "";
    }

    public void clickLogoutButton(){
        clickElement(logoutButton, 3);
    }

    public boolean isUserLogout(){
        return isElementDisplayed(userLabelOffline) && isElementDisplayed(loginButton);
    }
}
