package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pageFactory;
    Page page;
    protected Properties properties;

    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters({ "browser" })
    @BeforeMethod
    public void setup(String browserName) {
        pageFactory = new PlaywrightFactory();
        properties = pageFactory.initProperties();

        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }

        page = pageFactory.initBrowser(properties);
        page.setViewportSize(1920, 1080);
        homePage = new HomePage(page);
    }

    @AfterMethod
    public void tearDown() {
        page.context().browser().close();
    }

}
