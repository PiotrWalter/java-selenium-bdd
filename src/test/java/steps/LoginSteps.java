package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private BasePage basePage;


    // PicoContainer injects BaseStep class
    public LoginSteps(BaseSteps baseSteps) {
        this.driver = baseSteps.driver;
        this.wait = baseSteps.wait;
        this.basePage = baseSteps.basePage;
        this.loginPage = basePage.goToLogin();
    }

    @When("Login using {} email and {} password")
    public void loginWithEmailAndPass(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        Assertions.assertTrue(basePage.isSignOutButtonDisplayed());
    }

    @Then("User in not logged in")
    public void userIsNotLoggedIn() {
        Assertions.assertTrue(basePage.isSignInButtonDisplayed());
    }

    @Then("Alert danger is displayed")
    public void alertDangerIsDisplayed() {
        Assertions.assertTrue(loginPage.isAlertDangerDisplayed());
    }

    @Then("Alert {} is visible")
    public void alertIsDisplayedAccordingToIncorrectCredentials(String expectedMessage) {
        Assertions.assertTrue(loginPage.getAlertText().contains(expectedMessage));
    }

}
