package org.espn.configuration.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 2);
        initElements(driver, this);
    }

    /**
     * Get driver.
     *
     * @return : WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get wait.
     *
     * @param intWait : second for explicit wait.
     * @return : WebDriverWait
     */
    private WebDriverWait getWait(Integer intWait) {
        return new WebDriverWait(driver, intWait);
    }

    /**
     * Wrapper for Visibility event with explicit wait,
     * should return true if element is displayed in screen, otherwise false.
     *
     * @param element : WebElement
     * @param intWait : explicit wait
     * @return : Boolean
     */
    public Boolean isElementDisplayed(WebElement element, Integer intWait) {
        try {
            getWait(intWait).until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    /**
     * Wrapper for Visibility event,
     * should return true if element is displayed in screen, otherwise false.
     *
     * @param element : WebElement
     * @return : Boolean
     */
    public Boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Wrapper for click event with explicit wait.
     *
     * @param element : WebElement
     * @param intWait : explicit wait
     */
    public void clickElement(WebElement element, Integer intWait) {
        getWait(intWait).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Wrapper for type on input event with explicit wait.
     *
     * @param element : WebElement
     * @param text    : text to sent
     * @param intWait : explicit wait
     */
    public void typeOnInput(WebElement element, String text, Integer intWait) {
        getWait(intWait).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    /**
     * Method for return to back page.
     */
    public void goToPreviousPage() {
        driver.navigate().back();
    }

    /**
     * Method for reload page.
     */
    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void waitForPresenceOfElement(String locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }
}

