package org.espn.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Mobile automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/espn/tests/features",
        glue = {"org.espn.tests.stepsDefinitions.mobile"},
        tags = "@mobileAutomation")
public class CucumberTestRunnerMobile extends AbstractTestNGCucumberTests {
}
