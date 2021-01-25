package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends BasePage{

    @FindBy(id = "customer_firstname")
    private WebElement customer_firstname;

    @FindBy(id = "customer_lastname")
    private WebElement customer_lastname;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement id_state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private WebElement registerAlertMainText;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol")
    private WebElement registerAlertDetailsText;

    public CreateAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillAccountDetails(String firstName, String lastName, String email, String password, String address1,
                                   String state, String postcode, String phone) {
        customer_firstname.sendKeys(firstName);
        customer_lastname.sendKeys(lastName);
        emailBox.clear();
        emailBox.sendKeys(email);
        passwd.sendKeys(password);
        this.address1.sendKeys(address1);
        //this.city.sendKeys(city);
        Select stateSelect = new Select(this.id_state);
        stateSelect.selectByVisibleText(state);
        this.postcode.sendKeys(postcode);
        this.phone_mobile.sendKeys(phone);
        this.phone_mobile.sendKeys(Keys.ENTER);
    }

}
