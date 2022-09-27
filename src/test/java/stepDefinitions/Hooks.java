package stepDefinitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import utils.BrowserFactory;
import utils.PropertiesHandler;
import utils.WebActions;

import java.io.File;

public class Hooks {

    @Before
    public void setUp(){
        PropertiesHandler prop = new PropertiesHandler(new File("src/test/resources/global.properties"));
        BrowserFactory.setDriver(prop.getProperty("browser"));
        BrowserFactory.getDriver().get(prop.getProperty("url"));
        BrowserFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(){
        BrowserFactory.getDriver().quit();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        PropertiesHandler prop = new PropertiesHandler(new File("src/test/resources/global.properties"));
        Status status = scenario.isFailed() ? Status.FAIL : Status.PASS;
        if(prop.getProperty("screenshotsEveryStep").equalsIgnoreCase("yes") || scenario.isFailed())
            scenario.attach(new WebActions(BrowserFactory.getDriver()).getByteScreenshot(),
                    "image/jpeg","");
    }
}
