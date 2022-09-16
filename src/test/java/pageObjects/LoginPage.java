package pageObjects;

import org.openqa.selenium.By;
import utils.BrowserFactory;
import utils.PropertiesHandler;
import utils.WebActions;

import java.io.File;

public class LoginPage {
    private WebActions act;

    public LoginPage(){
        act = new WebActions(BrowserFactory.getDriver());
    }

    By userNameTxtBox = By.id("user-name");
    By passwordTxtBox = By.id("password");
    By loginBtn = By.id("login-button");

    public void enterUsername(String userName){
        act.enterText(userNameTxtBox, userName);
    }

    public void enterPassword(String password){
        act.enterText(passwordTxtBox, password);
    }

    public void clickLogin(){
        act.doClick(loginBtn);
    }

    public boolean isLoginPage(){
        PropertiesHandler props = new PropertiesHandler(new File("src/test/resources/global.properties"));
        return act.getCurrentURL().equalsIgnoreCase(props.getProperty("url"));
    }

    public boolean isHomePage(){
        PropertiesHandler props = new PropertiesHandler(new File("src/test/resources/global.properties"));
        return act.getCurrentURL().equalsIgnoreCase(props.getProperty("homepage"));
    }
}
