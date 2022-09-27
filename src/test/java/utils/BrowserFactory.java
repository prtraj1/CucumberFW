package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        return driver.get();
    }

    public synchronized static void setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("edge")) {
            driver.set(WebDriverManager.edgedriver().create());
        } else if (browserName.equalsIgnoreCase("docker")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-dev-shm-usage");
            try {
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            driver.set(WebDriverManager.chromedriver().create());
        }
    }
}
