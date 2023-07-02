package com.qa.opencart.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTestSuite extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;

    String searchedProduct = "iphone";

    @Test
    public void loginAsConsumer() {
        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.logInAsCustomer();
        homePage = accountPage.returnToHomePage();

        homePage.searchProduct(searchedProduct);
    }


}
