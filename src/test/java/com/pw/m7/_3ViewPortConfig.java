package com.pw.m7;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pw.ScriptBase.home;

public class _3ViewPortConfig {

    Playwright pw;
    Browser browser;

    @Test
    public void viewPortConfigDemo() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        BrowserContext ctx = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(375, 667) // that of iPhone 6/7/8
        );


        Page page = ctx.newPage();
        page.navigate(home);

        // verify that the UI is still usable
        page.click("#clap-image");
        Assertions.assertTrue(page.isVisible("#thank-you"));
    }

    @AfterEach
    public void cleanup() {
        browser.close();
        pw.close();
    }
}
