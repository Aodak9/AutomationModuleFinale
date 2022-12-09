package org.espn.showable.pages;

import org.espn.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIframe extends WebOperations {
    @FindBy(id = "logo")
    private WebElement espnLogoForm;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInputForm;

    @FindBy(id = "InputPassword")
    private WebElement passwordInputForm;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonSubmitForm;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonSubmitForm;

    @FindBy(id = "oneid-iframe")
    private WebElement signUpIframe;

    @FindBy(css = "#Title > span")
    private WebElement accountDeactivatedSpan;

    @FindBy(css = "#TextBlock > strong")
    private WebElement emailAccountDeactivated;
    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public LoginIframe(WebDriver driver) {
        super(driver);
    }

    public Boolean areLoginFormElementsDisplayed() {
        return isElementDisplayed(espnLogoForm, 3) && isElementDisplayed(emailInputForm, 3) && isElementDisplayed(passwordInputForm, 3) && isElementDisplayed(loginButtonSubmitForm, 3) && isElementDisplayed(signUpButtonSubmitForm, 3);
    }

    public SignUpIframe clickSignUpButton() {
        clickElement(signUpButtonSubmitForm, 0);
        return new SignUpIframe(getDriver());
    }
}
