package org.espn.showable.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.espn.configuration.mobile.MobileOperations;

public class BaseScreen extends MobileOperations {
    /**
     * Constructor method.
     * Allows to:
     * <ul>
     *     <li>Receive the AndroidDriver</li>
     *     <li>Define general wait duration</li>
     *     <li>Initialize web elements</li>
     * </ul>
     *
     * @param driver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
