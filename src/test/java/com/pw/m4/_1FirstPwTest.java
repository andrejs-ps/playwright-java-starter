package com.pw.m4;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class _1FirstPwTest {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void firstPlayWrightTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            BrowserContext context = browserType.launch().newContext();
            Page page = context.newPage();
            page.navigate(home);
            Assertions.assertEquals(page.title(), "Home Page");
        }
    }

    @Test
    public void secondPlayWrightTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            BrowserContext context = browserType.launch().newContext();
            Page page = context.newPage();
            page.navigate(home);
            String content = page.content();
            Assertions.assertTrue(content.contains("Cat In The Bag"));
        }
    }
}
