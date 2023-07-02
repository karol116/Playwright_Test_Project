package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTestSuite extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;
    LogoutPage logoutPage;

    @Test
    public void loginAsConsumer() {
        loginPage = homePage.goToLoginPage();

        accountPage = loginPage.logInAsCustomer();
        assertTrue(accountPage.isUserLogged());
    }

    @Test
    public void logOutAsConsumer() {
        loginAsConsumer();

        logoutPage = accountPage.logOut();
        assertEquals("Account Logout", logoutPage.getLogoutMessage());
    }
}