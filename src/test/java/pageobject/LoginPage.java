package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BasePage;

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

    @FindBy(className = "alert-danger")
    private WebElement authAlert;

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

}
