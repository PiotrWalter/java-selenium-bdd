package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    void shouldDispalyInvalidEmailAlertWrongEmailIsProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLogin();

    }
}