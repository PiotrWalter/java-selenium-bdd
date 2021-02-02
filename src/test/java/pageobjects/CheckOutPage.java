package pageobjects;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage extends BasePage{


    public CheckOutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(className = "checker")
    WebElement agreeOnTermsButton;

    @FindBy(className = "bankwire")
    WebElement payByBankWireButton;

    @FindBy(className = "cheque")
    WebElement payByCheckButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement confirmOrderButton;

    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//*[@id='form']/p/button")
    WebElement proceedOnShippingButton;

    @FindBy(name = "processAddress")
    WebElement secondTypeProceedToCheckOutButton;

    @FindBy(className = "page-heading")
    WebElement orderConfirmationInfo;

    @FindBy(className = "cheque-indent")
    WebElement orderStatusField;


    public void proceedThroughCheckOutFromCartSummary(String chosenOption) {
        //make is simpler
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));
        proceedToCheckOutButton.click();
        //address
        wait.until(ExpectedConditions.elementToBeClickable(secondTypeProceedToCheckOutButton));
        secondTypeProceedToCheckOutButton.click();
        //shipping
        agreeOnTerms();
        //payment
        chosePaymentOption(chosenOption);
        confirmMyOrder();
    }

    public void agreeOnTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeOnTermsButton));
        agreeOnTermsButton.click();
        proceedOnShippingButton.click();
    }

    public void chosePaymentOption(String chosenOption) {
        wait.until(ExpectedConditions.elementToBeClickable(payByBankWireButton));
        if (chosenOption.equals("bank wire")) {
            payByBankWireButton.click();
        }
        else {
            payByCheckButton.click();
        }
    }

    public void confirmMyOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        confirmOrderButton.click();
    }

    public String returnOrderStatus() {
        wait.until(ExpectedConditions.visibilityOf(orderStatusField));
        return orderStatusField.getText();
    }

}
