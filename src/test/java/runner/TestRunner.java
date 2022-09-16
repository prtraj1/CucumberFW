package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@LoginFunctionality",
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        })
public class TestRunner extends AbstractTestNGCucumberTests {
}
