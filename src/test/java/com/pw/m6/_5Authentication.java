package com.pw.m6;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class _5Authentication {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @AfterEach
    void closeContext() {
        page.close();
        context.close();
    }

    @Test
    public void auth() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://github.com/login");

        page.fill("#login_field", "andrejs-ps");
        page.fill("#password", "password_placeholder");
        page.click("'Sign in'");
        Assertions.assertEquals(page.url(), "https://github.com/");
        page.click("[aria-label=\"View profile and more\"]");
        page.click("text=Signed in as andrejs-ps");

        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }


    @Test
    public void auth2() {
        // Create a new context with the saved storage state.
        context = browser.newContext(
                new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));

        page = context.newPage();
        page.navigate("https://github.com");
        // verify already logged in
        page.click("[aria-label=\"View profile and more\"]");
        page.click("text=Signed in as andrejs-ps");
    }
}
