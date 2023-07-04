package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.pages.ShoppingCartPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class BuyItemEndToEndTest extends BaseTest {
    SearchResultsPage searchResultsPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void checkBuyingNotAvailableProductAlert() {
        String productName = "iphone";

        searchResultsPage = homePage.searchProduct(productName);
        searchResultsPage.addToCart();

        shoppingCartPage = searchResultsPage.openShoppingCart();
        shoppingCartPage.clickCheckout();
        assertTrue(shoppingCartPage.isProductNotInStockAlertVisible());
    }
}
