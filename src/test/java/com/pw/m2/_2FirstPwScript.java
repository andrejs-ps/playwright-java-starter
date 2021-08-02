package com.pw.m2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class _2FirstPwScript {

    @Test
    // first basic script
    public void firstPlayWrightScript() {

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }

    // Note: neither uses the BrowserContext - will start using later
    @Test
    // refactored basic script
    public void firstPlayWrightScriptRefactored() {
        try (Playwright playwright = Playwright.create()) {
            Page page = playwright.chromium().launch().newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }
}
