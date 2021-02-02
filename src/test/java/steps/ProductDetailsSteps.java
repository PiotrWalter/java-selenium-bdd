package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.ProductDetailsPage;
import pageobjects.ProductsListPage;

public class ProductDetailsSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private ProductsListPage productsListPage;
    private ProductDetailsPage productDetailsPage;

    public ProductDetailsSteps(BaseSteps baseSteps, ShoppingSteps shoppingSteps, ProductsListPage productsListPage) {
        this.driver = baseSteps.driver;
        this.wait = baseSteps.wait;
        this.basePage = baseSteps.basePage;
        //this.productsListPage = productsListPage;
        //this.productDetailsPage = productsListPage;

    }

//    @When("I click on product")
//    public void goToRandomProductDetails() {
//        productDetailsPage = productsListPage.choseRandomItemFromProductList();
//    }

//    @When("I click on add to cart button")
//    public void addProductToCart() {
//        //productsListPage.choseRandomItemFromProductList();
//        productDetailsPage.addToCart();
//    }
//
//    //do productDetailsSteps
//    @Then("System show product details")
//    public void checkIsProductNameOnDetailsCorrect() {
//        var test = productsListPage.getMyProduct();
//        var test2 = productDetailsPage.getProductNameFromProductDetails();
//        Assertions.assertEquals(test, test2);
//    }

}
