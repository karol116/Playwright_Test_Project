package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class AbstractPage {
    Page page;

    AbstractPage(Page page) {
        this.page = page;
    }
}
