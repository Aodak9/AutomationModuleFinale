package org.espn.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Web automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/espn/tests/features",
        glue = {"org.espn.tests.stepsDefinitions.web"},
        tags = "@webAutomation"
)
public class CucumberTestRunnerWeb extends AbstractTestNGCucumberTests {

}
