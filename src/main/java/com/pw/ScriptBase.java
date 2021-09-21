package com.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ScriptBase {

    public static String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";
    protected String advantages = "file:///" + System.getProperty("user.dir") + "\\src\\web\\advantages.html";

    // Refactoring 1 - extract PW and browser
    // Shared between all tests
    protected static Playwright playwright;
    protected static Browser browser;

    // Refactoring 2
    // New instance for each test method.
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                // headless=false for demo purposes
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    protected void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080); // make part of demo
        page.setDefaultTimeout(8000); // not part of demo
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
