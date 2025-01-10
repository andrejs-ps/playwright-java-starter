package com.pw.m5;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class NavigationOptions {

    @Test
    void navigationTest(Page page) {
        page.navigate(HOME_WEB);

        assertThat(page).hasTitle("Credit Association");

    }

    @Test
    void challengeTest(Page page) {
        page.navigate(HOME_WEB);

    }
}
