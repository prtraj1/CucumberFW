package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {

    private WebDriver driver;

    private int maxRetryCount = 2;

    private WebDriverWait wait;

    private JavascriptExecutor js;

    public WebActions(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) this.driver;
    }

    public void doClick(By element){
        int retryCount = 0;
        while (true){
            if(retryCount > maxRetryCount)
                throw new RuntimeException("Unable to click element: "+element);
            try{
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                ExtentLogs.log("Clicked on element: " + element);
                break;
            }catch (Exception e){
                retryCount++;
            }
        }
    }

    public void enterText(By element, String text){
        int retryCount = 0;
        while (true){
            if(retryCount > maxRetryCount)
                throw new RuntimeException("Unable to enter text in the element: "+element);
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(text);
                ExtentLogs.log("Entered text: "+text+" on element: " + element);
                break;
            }catch (Exception e){
                retryCount++;
            }
        }
    }

    public void doJSClick(By element){
        int retryCount = 0;
        while (true){
            if(retryCount > maxRetryCount)
                throw new RuntimeException("Unable to click element: "+element);
            try{
                wait.until(ExpectedConditions.elementToBeClickable(element));
                js.executeScript("arguments[0].click()", driver.findElement(element));
                ExtentLogs.log("Clicked on element: " + element);
                break;
            }catch (Exception e){
                retryCount++;
            }
        }
    }

    public String getBase64screenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
}
