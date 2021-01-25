package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsListPage extends BasePage{

    public ProductsListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(className = "heading-counter")
    WebElement resultsCounter;

    public String getNumberOfProductsOnPage() {
        wait.until(ExpectedConditions.visibilityOf(resultsCounter));
        return resultsCounter.getText();
    }

}
