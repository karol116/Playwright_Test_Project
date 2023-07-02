package com.qa.opencart.pages;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;

import java.util.Properties;

public class LoginPage extends AbstractPage {
    Page page;

    LoginPage(Page page){
        super(page);
        this.page = page;
    }

    PlaywrightFactory playwrightFactory = new PlaywrightFactory();
    Properties properties = playwrightFactory.initProperties();

    private String emailInputField = "#input-email";
    private String passwordInputFiled = "#input-password";
    private String submitLoginButton = "//input[@type='submit' and @value='Login']";

    public AccountPage logInAsCustomer(){
        page.fill(emailInputField, properties.getProperty("username"));
        page.fill(passwordInputFiled, properties.getProperty("password"));
        page.click(submitLoginButton);
        return new AccountPage(page);
    }
}
