package org.espn.tests.stepsDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.espn.configuration.web.Driver;
import org.espn.reporting.Reporter;
import org.openqa.selenium.WebDriver;

public class WebHooks {
    private static Driver driver;

    /**
     * Before Hook for set up
     */
    @Before
    public void setUp(){
        String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        driver = new Driver();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + URL);
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
    }

    /**
     * After Hook for tear down web-driver.
     */
    @After
    public void tearDown(){
        Reporter.info("Exit from driver");
        driver.getDriver().quit();
    }

    /**
     * Gets the current driver.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver(){
        return driver.getDriver();
    }
}


