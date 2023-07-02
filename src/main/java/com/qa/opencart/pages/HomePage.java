package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private Locator locator;

    public HomePage(Page page) {
        this.page = page;
    }

    private String searchInput = "//input[@name='search']";
    private String searchButton = "//*[@id='search']//button";
    private String myAccountButton = "//*[@title='My Account']";
    private String loginButton = "//*[@title='My Account']/../..//a[text()='Login']";
//    private String

    public SearchResultsPage searchProduct(String productName) {
        page.fill(searchInput, productName);
        page.click(searchButton);
        return new SearchResultsPage(page);
    }
    public LoginPage goToLoginPage(){
        page.click(myAccountButton);
        page.click(loginButton);
        return new LoginPage(page);
    }

//    public String getFirstResultProductName(){
//        page.locator()
//    }
}
