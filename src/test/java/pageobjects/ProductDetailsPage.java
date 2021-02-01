package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement productNameDetails;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    @FindBy(className = "icon-ok")
    WebElement addToCartConfirmationIcon;


    public String getProductNameFromProductDetails() {
        wait.until(ExpectedConditions.visibilityOf(productNameDetails));
        var productDetailsName = productNameDetails.getText();
        System.out.println(productNameDetails.getText()); //debug
        return productDetailsName;
    }

    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public boolean checkIsProductAddedToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartConfirmationIcon));
        return true;
    }


}
