package com.pw.m4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class _2FirstPwTestRefactored {

    // Refactoring 1 - extract PW and browser
    // Shared between all tests
    static Playwright playwright;
    static Browser browser;

    // Refactoring 2
    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @Test
    public void firstPlayWrightTest() {
        Page page = browser.newPage();
        page.navigate("file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html");
        Assertions.assertEquals(page.title(), "Home Page");
    }

    @Test
    public void secondPlayWrightTest() {
        Page page = browser.newPage();
        page.navigate("file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html");
        String content = page.content();
        Assertions.assertTrue(content.contains("Cat In The Bag Inc."));
    }

}
