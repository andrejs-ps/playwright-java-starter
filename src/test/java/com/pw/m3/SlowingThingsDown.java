package com.pw.m3;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.pw.Constants.HOME_WEB;

public class SlowingThingsDown {

    @Test
    void firstPlayWrightScriptRefactoredNew() {
        try (var pw = Playwright.create();
             var browser = pw.chromium().launch()) {
            Page page = browser.newPage();
            page.navigate(HOME_WEB);
            System.out.println(page.title());
        }
    }
}
