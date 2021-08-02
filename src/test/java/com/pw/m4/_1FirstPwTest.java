package com.pw.m4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class _1FirstPwTest {

    @Test
    public void firstPlayWrightTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            Page page = browser.newPage();
            page.navigate("file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html");
            Assertions.assertEquals(page.title(), "Home Page");
        }
    }

    @Test
    public void secondPlayWrightTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            Page page = browser.newPage();
            page.navigate("file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html");
            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag Inc."));
        }
    }

}
