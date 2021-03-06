package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.ProductsListPage;
import pageobjects.ProductDetailsPage;
import pageobjects.CheckOutPage;

public class ShoppingSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private ProductsListPage productsListPage;
    private ProductDetailsPage productDetailsPage;
    private CheckOutPage checkOutPage;

    public ShoppingSteps(BaseSteps baseSteps) {
        this.driver = baseSteps.driver;
        this.wait = baseSteps.wait;
        this.basePage = baseSteps.basePage;
    }

    //SEARCH STEPS

    @When("Search {} using search box")
    public void searchProductUsingSearchField(String item) {
        productsListPage = basePage.searchItemUsingSearchBox(item);
    }

    @Then("System show {} results")
    public void confirmNumberOfResultsOnPage (int expectedNumberOfResult) {
        Assertions.assertTrue(productsListPage.checkIsNumberOfProductCorrect(expectedNumberOfResult));
    }


    @Then("System show correct item count {}")
    public void confirmNumberOfResultsOnPage(String expectedNumberOfResults) {
        Assertions.assertTrue(productsListPage.getNumberOfProductsOnPage().contains(expectedNumberOfResults));
    }

    @Then("System show products containing searched phrase {}")
        public void checkIsSearchedPhraseInProducts(String expectedProduct) {
        Assertions.assertTrue(productsListPage.checkIsSearchedPhraseInProducts(expectedProduct));
    }

    //SHOPPING STEPS

    //Chose random item from list
    @When("Click on product")
    public void goToRandomProductDetails() {
        productDetailsPage = productsListPage.choseRandomItemFromProductList();
    }

    //Checking is on product details and compare names of chosen product with name from product details
    @Then("System show product details")
    public void checkIsProductNameOnDetailsCorrect() {
        var test = productsListPage.getMyProduct();
        var test2 = productDetailsPage.getProductNameFromProductDetails();
        Assertions.assertEquals(test, test2);
    }

    //Adding item to cart
    @When("Click on add to cart button")
    public void addProductToCart() {
        //productsListPage.choseRandomItemFromProductList();
        productDetailsPage.addToCart();
    }

    @Then("Product is added to cart")
    public void checkIsProductAddedToCart() {
        Assertions.assertTrue(productDetailsPage.checkIsProductAddedToCart());
    }

    @When("Proceed to checkout")
    public void proceedToCheckout() {
        checkOutPage = productDetailsPage.proceedToCheckout();
    }

    @When("Delete item from cart")
    public void deleteItemFromCart () {
        productDetailsPage.deleteItemFromShoppingCart();
    }

    @Then("Product is removed from cart and empty cart alert is visible")
    public void checkIsProductRemovedFromCart() {
        Assertions.assertTrue(productDetailsPage.isCartIsEmptyAlertVisible());
    }

    //buy chosen product and full checkout
    @When("I buy random {} and pay by {}")
    public void searchItemAddRandomItemCheckOutAndBuyUsingChosePaymentMethod(String item, String chosenOption) {
        productsListPage = basePage.searchItemUsingSearchBox(item);
        productDetailsPage = productsListPage.choseRandomItemFromProductList();
        productDetailsPage.addToCart();
        checkOutPage = productDetailsPage.proceedToCheckout();
        checkOutPage.proceedThroughCheckOutFromCartSummary(chosenOption);
    }

    @When("Check out using pay by {}")
    public void proceedThroughWholeCheckout(String chosenOption) {
        checkOutPage.proceedThroughCheckOutFromCartSummary(chosenOption);
    }

    @Then("Order is complete and system show {} message")
    public void checkIsOrderComplete(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, checkOutPage.returnOrderStatus());
    }

}
