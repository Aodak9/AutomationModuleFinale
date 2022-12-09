package org.espn.showable.pages;

import org.espn.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebOperations {
    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(css = ".pillar.watch")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public OptionsForUser goToOptionsForUser(){
        isElementDisplayed(espnLogo, 3);
        isElementDisplayed(watchLink, 3);
        clickElement(userButton, 3);
        return new OptionsForUser(super.getDriver());
    }

    public WatchPage goToWatchPage(){
        super.clickElement(watchLink, 10);
        return new WatchPage(super.getDriver());
    }
}
