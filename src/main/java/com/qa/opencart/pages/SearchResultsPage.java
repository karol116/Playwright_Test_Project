package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

import java.awt.*;

public class SearchResultsPage extends AbstractPage{
    Page page;
    public SearchResultsPage(Page page){
        super(page);
        this.page = page;
    }

    private String addToCartButton = "//button//*[text()='Add to Cart']";
    private String searchedProductNameResult =  "//div[@class='product-thumb']//div[@class='caption']//a";

    String getSearchedProductNameResult() {
        return page.innerText(searchedProductNameResult);
    }

    public void addToCart(){
        page.click(addToCartButton);
        page.waitForSelector("//*[contains(@class, 'alert-succes')]//*[text()='"+ getSearchedProductNameResult()+"']");
    }
}