package org.espn.showable.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains all 'Add Plans' screen elements and methods.
 */
public class AddPlansScreen extends BaseScreen{

    @AndroidFindBy(id = "actionSheetItemText")
    private List<AndroidElement> addPlansOptions;

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
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Verifies if 'Check Dining Availability' option is displayed.
     * @return true if 'Check Dining Availability' option is displayed in the screen, otherwise false
     */
    public boolean checkDiningAvailabilityDisplayed() {
        List<Boolean> isCheckDiningAvailabilityOption = new ArrayList<>();
        waitForVisibilityOfAll(addPlansOptions);
        addPlansOptions.stream().forEach(element -> {
            isCheckDiningAvailabilityOption.add(element.getText().equals("Check Dining Availability"));
        });
        return isCheckDiningAvailabilityOption.contains(true);
    }
}
