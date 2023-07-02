package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LogoutPage extends AbstractPage {
    LogoutPage(Page page) {
        super(page);
        this.page = page;
    }

    private String logoutMessageTextField = "//div[@id='content']/h1";

    public String getLogoutMessage(){
        return page.innerText(logoutMessageTextField);
    }
}