package com.pw.m9;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class Inspector {

    @Test
    void traceViewerFailingTestDemo(Playwright pw) {

        var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newContext().newPage();
        page.navigate("https://playwright.dev/java/");


        page.pause();
        // OR
        // mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://playwright.dev/"
    }
}
