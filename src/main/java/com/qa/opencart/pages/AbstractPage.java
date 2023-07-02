package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.NoSuchElementException;

public class AbstractPage {
    Page page;

    AbstractPage(Page page) {
        this.page = page;
    }

    private String returnToHomePageButton = "//*[@class='fa fa-home']/../..";
    private String myAccountButton = "//*[@title='My Account']";
    private String dropdownList = "//*[@title='My Account']/../ul/li";
    private String logoutButton = "//ul/li/a[text()='Logout']";

    public HomePage returnToHomePage() {
        page.click(returnToHomePageButton);
        return new HomePage(page);
    }

    public LogoutPage logOut() {
        try {
            page.click(logoutButton);
            return new LogoutPage(page);
        } catch (NoSuchElementException e) {
            page.click(myAccountButton);
            page.click(logoutButton);
            return new LogoutPage(page);
        }
    }

    public boolean isUserLogged() {
        page.click(myAccountButton);
        List<String> options = page.locator(dropdownList).allInnerTexts();
        for (String searchedOption : options) {
            if (searchedOption.equals("Logout"))
                return true;
        }
        return false;
    }
}