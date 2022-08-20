package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    private static final String
    LOGIN_BTN = "xpath://a[text()='Log in']",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BTN = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton(){
        this.waitForElementPresent(LOGIN_BTN, "Cannot find auth button", 5);
        this.tryClickElementWithFewAttempts(LOGIN_BTN, "Cannot find auth button", 5);
    }

    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(LOGIN_INPUT, login,"Cannot find and put login input", 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, login,"Cannot find and put password input", 5);
    }

    public void submitForm(){
        if (!LOGIN_INPUT.isEmpty() && !PASSWORD_INPUT.isEmpty()){
            this.waitForElementAndClick(SUBMIT_BTN, "Cannot find submit button", 5);
        } else {
            System.out.println("LOGIN_INPUT and PASSWORD_INPUT must be filled");
        }
    }
}
