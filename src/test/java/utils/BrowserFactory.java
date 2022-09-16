package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        return driver.get();
    }

    public synchronized static void setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("edge")) {
            driver.set(WebDriverManager.edgedriver().create());
        } else {
            driver.set(WebDriverManager.chromedriver().create());
        }
    }
}
