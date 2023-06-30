package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private String searchInput = "//input[@name='search']";
    private String searchButton = "//*[@id='search']//button";

    public SearchResultsPage searchProduct(String productName) {
        page.fill(searchInput, productName);
        page.click(searchButton);
        return new SearchResultsPage(page);
    }
}
