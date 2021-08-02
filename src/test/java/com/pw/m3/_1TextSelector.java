package com.pw.m3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class _1TextSelector {

    String selectors = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void textSelectorsTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate(selectors);

            page.click("text=More Info");
            assertEquals(page.title(), "Advantages");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "text=More Info", // perfect match, but doesn't have to be
            "text=more info", // case insensitive, also works
            "'More Info'"})   // can be without 'text=' if enclosed in '', but then it's case sensitive
    public void textSelectorsTestParametrized(String stringSelector) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate(selectors);

            page.click(stringSelector); // perfect match
            assertEquals(page.title(), "Advantages");
        }
    }
}
