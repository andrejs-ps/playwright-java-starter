package com.pw.m6;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;

@UsePlaywright
public class Authentication {

    @Test
    void authDemoCreate(Playwright pw) {
        var ctx = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext();
        var page = ctx.newPage();

        page.navigate("https://github.com/login");

        page.locator("#login_field").fill("your username");
        page.locator("#password").fill("your password");
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();


//        page.getByPlaceholder("XXXXXX").fill("some num here");

        assertThat(page.getByLabel("Open user navigation menu")).isVisible();
    }



    @Test
    void authDemoUse(Browser browser) {
        // Create a new context with the saved storage state.
        var ctx = browser.newContext();

        var page = ctx.newPage();
        page.navigate("https://github.com");

        // verify already logged in
        assertThat(page.getByLabel("Open user navigation menu")).isVisible();
    }
}
