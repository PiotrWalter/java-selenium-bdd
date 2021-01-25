package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.LoginPage;
import pageobjects.CreateAccountPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected BasePage basePage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected CreateAccountPage createAccountPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @After
//    public void tearDown() throws IOException {
//        driver.quit();
//    }

    @Given("Open homepage")
    public void open_homepage() {
        basePage = new BasePage(driver, wait);
        basePage.open();
    }

    @And("Go to login page")
    public void goToLoginPage() {
        loginPage = basePage.goToLogin();
    }

    @Given("Open login page")
    public void openLoginPage() {
        basePage = new BasePage(driver, wait);
        basePage.open();
        loginPage = basePage.goToLogin();
    }

    @When("Logout button is clicked")
    public void clickLogOutButton() {
        basePage.clickOnSignOutButton();
    }
}