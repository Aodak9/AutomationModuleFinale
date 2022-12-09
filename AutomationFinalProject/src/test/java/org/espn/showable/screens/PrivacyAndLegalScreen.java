package org.espn.showable.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrivacyAndLegalScreen extends BaseScreen{

    @AndroidFindBy(id = "txt_element")
    private List<AndroidElement> privacyAndLegalOptions;

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
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Verifies if all the options at the end of the 'Privacy and Legal' screen are the expected ones (defined inside de method).
     * @return true if all the listed options at the end of the 'Menu' screen are the expected ones, otherwise false.
     */
    public boolean checkPrivacyAndLegalOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedOptions,
                "Privacy Policy",
                "Terms of Use",
                "Supplemental Terms and Conditions",
                "Legal Notices",
                "Property Rules",
                "Electronic Communications Disclosure",
                "Your California Privacy Rights",
                "Do Not Sell My Personal Information",
                "In-App Maps Subject to Google Terms and Conditions",
                "In-App Maps Subject to Google Privacy Policy"
        );
        waitForVisibilityOfAll(privacyAndLegalOptions);
        for (int i = 0; i < privacyAndLegalOptions.size() ; i++) {
            isCorrect.add(privacyAndLegalOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !isCorrect.contains(false);
    }
}
