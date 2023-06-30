package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties properties;

    private static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }

    public Page initBrowser(Properties properties) {
        String browserName = properties.getProperty("browser").trim();

        playwrightThreadLocal.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium":
                browserThreadLocal
                        .set(getPlaywright()
                                .chromium()
                                .launch(new BrowserType.LaunchOptions()
                                        .setHeadless(false)));
                break;
            case "firefox":
                browserThreadLocal
                        .set(getPlaywright()
                                .firefox()
                                .launch(new BrowserType.LaunchOptions()
                                        .setHeadless(false)));
                break;
            case "safari":
                browserThreadLocal
                        .set(getPlaywright()
                                .webkit()
                                .launch(new BrowserType.LaunchOptions()
                                        .setHeadless(false)));
                break;
            case "chrome":
                browserThreadLocal
                        .set(getPlaywright()
                                .chromium()
                                .launch(new BrowserType.LaunchOptions()
                                        .setChannel("chrome")
                                        .setHeadless(false)));
                break;
            case "edge":
                browserThreadLocal
                        .set(getPlaywright()
                                .chromium()
                                .launch(new BrowserType.LaunchOptions()
                                        .setChannel("edge")
                                        .setHeadless(false)));
                break;
            default:
                System.out.println("Pass browser name");
                break;
        }

        browserContextThreadLocal.set(getBrowser().newContext());
        pageThreadLocal.set(getBrowserContext().newPage());
        getPage().navigate(properties.getProperty("url").trim());
        return getPage();
    }

    public Properties initProperties() {
        try {
            FileInputStream inputStream = new FileInputStream("./src/test/resources/config.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
