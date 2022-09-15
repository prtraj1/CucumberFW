package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@LoginFunctionality",
        features = {"src/test/features"},
        glue = {"stepDefinitions"},
        dryRun = true,
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class TestRunner extends AbstractTestNGCucumberTests {
}
