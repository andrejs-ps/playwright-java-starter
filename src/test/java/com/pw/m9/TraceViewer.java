package com.pw.m9;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TraceViewer {

    @Test
    void traceViewerDemo(Browser browser) {
        var context = browser.newContext();
        var page = context.newPage();

        //  ----------- Start capturing here -----------

        page.navigate("https://playwright.dev/java/");
        page.getByRole(AriaRole.LINK, name("Get started")).click();
        page.getByRole(AriaRole.LINK, name("Trace viewer")).nth(1).click();

        var title = page.getByRole(AriaRole.HEADING, name("Trace viewer").setExact(true));
        assertThat(title).isVisible();

        //  ----------- Finish capturing here -----------


    }

    static Page.GetByRoleOptions name(String name) {
        return new Page.GetByRoleOptions().setName(name);
    }

}
