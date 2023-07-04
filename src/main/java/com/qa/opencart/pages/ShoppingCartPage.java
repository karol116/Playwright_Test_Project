package com.qa.opencart.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.NoSuchElementException;

public class ShoppingCartPage extends AbstractPage {
    Page page;

    ShoppingCartPage(Page page) {
        super(page);
        this.page = page;
    }

    String checkoutButton = "//*[@class='buttons clearfix']";
    String productNotAvailableAlert = "//*[contains(@class, 'alert-danger') and contains(text(), 'not available')]";

    public void clickCheckout(){
        page.click(checkoutButton);
    }
     public boolean isProductNotInStockAlertVisible(){
         try {
             page.waitForSelector(productNotAvailableAlert);
             return true;
         } catch (NoSuchElementException e) {
            e.printStackTrace();
             return false;
         }
     }

}