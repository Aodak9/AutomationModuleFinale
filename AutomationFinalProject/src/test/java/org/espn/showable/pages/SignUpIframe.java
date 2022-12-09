package org.espn.showable.pages;

import org.espn.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpIframe extends WebOperations {
    @FindBy(id = "Title")
    private WebElement titleSignUpForm;

    @FindBy(id = "close")
    private WebElement closeBtnSignUpForm;

    @FindBy(id = "InputFirstName")
    private WebElement nameInputSignUpForm;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSignUpForm;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSignUpForm;

    @FindBy(id = "password-new")
    private WebElement passwordInputSignUpForm;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpButtonSubmitForm;
    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public SignUpIframe(WebDriver driver) {
        super(driver);
    }

    public Boolean areSignUpFormElementsDisplayed(){
        return isElementDisplayed(titleSignUpForm, 3) && isElementDisplayed(closeBtnSignUpForm, 3) && isElementDisplayed(nameInputSignUpForm, 3) && isElementDisplayed(lastNameInputSignUpForm, 3) && isElementDisplayed(emailInputSignUpForm, 3) && isElementDisplayed(passwordInputSignUpForm, 3);
    }

    public void completeInformationForSignUp(String name, String lastName, String email, String password){
        typeOnInput(nameInputSignUpForm, name, 0);
        typeOnInput(lastNameInputSignUpForm, lastName, 0);
        typeOnInput(emailInputSignUpForm, email, 0);
        typeOnInput(passwordInputSignUpForm, password, 0);
    }

    public void clickToConfirmSignUpButton(){
        isElementDisplayed(signUpButtonSubmitForm, 3);
        clickElement(signUpButtonSubmitForm, 2);
    }
}

