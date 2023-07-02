package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AccountPage extends AbstractPage {
    Page page;

    AccountPage(Page page) {
        super(page);
    }

    String returnToHomePageButton = "//*[@class = 'fa fa-home']";

    public HomePage returnToHomePage(){
        page.click(returnToHomePageButton);
        return new HomePage(page);
    }

}
