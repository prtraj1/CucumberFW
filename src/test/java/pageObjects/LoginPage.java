package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.WebActions;

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
}
