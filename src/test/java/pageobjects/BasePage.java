package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    final String MAIN_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(linkText = "Sign in")
    WebElement signInButton;

    @FindBy(className = "logout")
    WebElement signOutButton;

    @FindBy(id = "search_query_top")
    WebElement searchInputField;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement goToDressesButton;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(MAIN_URL);
    }

    public LoginPage goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new LoginPage(driver, wait);
    }

    public boolean isSignInButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        return signInButton.isDisplayed();
    }

    public boolean isSignOutButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        return signOutButton.isDisplayed();
    }

    //HEADER METHODS
    public void searchItemUsingSearchBox(String item) {
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(item);
        // zrobić return strony ProductsListPage
    }

    public void clickOnSignOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton)).click();
    }
}
