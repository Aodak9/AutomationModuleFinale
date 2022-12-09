package org.espn.configuration.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Driver class.
 */
public class Driver {

    private WebDriver driver;

    /**
     * Constructor method for driver.
     */
    public Driver(){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
    }

    /**
     * Get driver.
     *
     * @return : WebDriver
     */
    public WebDriver getDriver(){
        return driver;
    }
}
