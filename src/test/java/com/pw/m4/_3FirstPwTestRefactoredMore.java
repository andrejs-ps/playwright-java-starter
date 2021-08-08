package com.pw.m4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;


public class _3FirstPwTestRefactoredMore {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

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

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void firstPlayWrightTest() {
        page.navigate(home);
        Assertions.assertEquals(page.title(), "Home Page");
    }

    @Test
    public void secondPlayWrightTest() {
        page.navigate(home);
        String content = page.content();
        Assertions.assertTrue(content.contains("Cat In The Bag"));
    }

}
