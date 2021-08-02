package com.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ScriptBase {

    protected String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    // Refactoring 1 - extract PW and browser
    // Shared between all tests
    static Playwright playwright;
    static Browser browser;

    // Refactoring 2
    // New instance for each test method.
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                // headless=false for demo purposes
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
