package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  extends BasePage {
//    private WebDriver driver;
//    private WebDriverWait wait;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "email_create")
    private WebElement email_create;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreate;

    @FindBy(linkText = "Authentication failed.")
    private WebElement alertDangerLink;

    @FindBy(className = "alert-danger") //zmienić ten locator
    private WebElement alertDanger;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;


    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    public CreateAccountPage startCreatingAccount(String email) {
        email_create.sendKeys(email);
        submitCreate.click();
        return new CreateAccountPage(driver, wait);
    }

    public boolean isAlertDangerDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertDangerLink));
        return alertDangerLink.isDisplayed();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return  alertDanger.getText();
    }


}
