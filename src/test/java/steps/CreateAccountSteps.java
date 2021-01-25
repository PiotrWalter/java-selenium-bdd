package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.LoginPage;
import pageobjects.CreateAccountPage;

public class CreateAccountSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private BasePage basePage;
    private CreateAccountPage createAccountPage;

    public CreateAccountSteps(BaseSteps baseSteps) {
        this.driver = baseSteps.driver;
        this.wait = baseSteps.wait;
        this.loginPage = baseSteps.loginPage;
        //this.createAccountPage = baseSteps.createAccountPage; //do wywalenia
    }

    @When("Create account using {} email")
        public void startCreatingAccount(String email) {
        createAccountPage = loginPage.startCreatingAccount(email); //nadawanie wartości zwracanej przez startCreatingAccount
    }

    @When("Create account using personal info: {} {} {} {} {} {} {} {}")
        public void fillAllFieldsWhenCreateAccount(String firstName, String lastName, String email, String password, String address1,
                                                   String state, String postcode, String phone) {
        createAccountPage.fillAccountDetails(firstName, lastName, email, password, address1, state, postcode, phone);
    }


}
