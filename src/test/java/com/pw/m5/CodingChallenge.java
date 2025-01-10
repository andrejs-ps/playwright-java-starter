package com.pw.m5;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.microsoft.playwright.options.AriaRole.CHECKBOX;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class CodingChallenge {

    @Test
    void codingChallenge(Playwright pw) {
        var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        var page = browser.newPage();
        page.navigate(HOME_WEB);

        String message = "msg";
        var checkbox = page.getByRole(CHECKBOX);
        var textarea = page.locator("#textarea");

        // check the checkbox
        // fill in text area



        // click "Save Input"



        // reload



        // assert that the checkbox remains checked and textarea filled in

    }
}
