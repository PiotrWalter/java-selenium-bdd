package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsListPage extends BasePage{

    public ProductsListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(className = "heading-counter")
    WebElement resultsCounter;

    @FindBy(css = ".product_list .product-container")
    List<WebElement> productContainers;

    @FindBy(css = ".product_list .product-container .product-name")
    List<WebElement> productNames;

    @FindBy(className = "product-name")
    WebElement productName;

    //counting products on page by counting page containers
    public int getNumberOfProductContainersVisibleOnPageResults() {
        wait.until(ExpectedConditions.visibilityOf(resultsCounter));
        return productContainers.size();
    }

    //checking is expected product number equals product containers on page
    public boolean checkIsNumberOfProductCorrect(int expectedNumberOfResult) {
        int numberOfProducts = getNumberOfProductContainersVisibleOnPageResults();
        return numberOfProducts == expectedNumberOfResult;
    }

    //returning product count from text box that counts products on page
    public String getNumberOfProductsOnPage() {
        wait.until(ExpectedConditions.visibilityOf(resultsCounter));
        return resultsCounter.getText();
    }

    //checking is searched phrase in all searched results
    public boolean checkIsSearchedPhraseInProducts(String searchedPhrase) {
        for (WebElement productName : productNames){
            if (productName.getText().contains(searchedPhrase)){
                return true;
            }

        }
        return false;
    }

}
