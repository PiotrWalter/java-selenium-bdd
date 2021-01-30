package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.ProductsListPage;
import pageobjects.LoginPage;

import java.util.List;

public class SearchSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private ProductsListPage productsListPage;

    public SearchSteps(BaseSteps baseSteps) {
        this.driver = baseSteps.driver;
        this.wait = baseSteps.wait;
        this.basePage = baseSteps.basePage;
    }

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

}
