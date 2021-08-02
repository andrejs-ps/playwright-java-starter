package com.pw.reference;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright.CreateOptions;
import com.microsoft.playwright.options.ColorScheme;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class PlayWrightOverview {

    @Test
    public void pwOverview() {

        // Step 1: Playwright as entry point
        // ----------------------------------------
        Playwright pw = Playwright.create(); // extends AutoCloseable
        // OR
        var pw2 = Playwright.create(new CreateOptions().setEnv(Map.of("var1", "key1")));

        // advanced stuff, see JavaDoc in Selectors class
//        pw.selectors().register("", "");

        // Step 2: choose your browser type
        // ----------------------------------------
        BrowserType chrome = pw.chromium(); // chrome, Edge, Opera (https://alternativeto.net/category/browsers/chromium-based/)
        BrowserType firefox = pw.firefox();
        BrowserType webkit = pw.webkit(); // Safari browsers + other iOS tech

        // only relevant when connecting over web sockets
//        chrome.connect("", new BrowserType.ConnectOptions().setSlowMo(200));

        // Step 3: Create a Browser instance
        // Playwright scripts generally start with launching a browser instance and end with closing the browser.
        // Can be launched in headless (without a GUI) or headed mode.
        // ----------------------------------------
        Browser chromeBr = chrome.launch();
        Browser chromeBr2 = chrome.launch(new BrowserType.LaunchOptions()
                                            .setHeadless(false) // true by default (faster)
                                            .setSlowMo(1_000)  // Slows down operations. Useful to see what is going on.
                                            .setTimeout(5_000));
                                            // + other interesting setters

        // Launches browser that uses persistent storage located at {@code userDataDir}
        //  which stores browser session data like cookies and local storage
//        BrowserContext ctx = chrome.launchPersistentContext(Path.of(URI.create("")));

        // Step 4: Create a Browser Context
        // an isolated incognito-alike session within a browser instance - fast and cheap to create.
        // Recommended to run each test in its own new Browser Context
        // ----------------------------------------
        BrowserContext chromeCtx = chromeBr2.newContext();
        BrowserContext chromeCtx2 = chromeBr2.newContext(new Browser.NewContextOptions()
                                            .setUserAgent("")
                                            .setBaseURL("https://github.com/microsoft/playwright-java")
                                            .setColorScheme(ColorScheme.DARK));
                                            // etc.
        // alternatively, skip the context and create a page directly
//        chromeBr.newPage();

        // Step 5: Create a Page
        // A Browser context can have multiple pages - single tab or a popup window within a Browser Context
        // ----------------------------------------

        Page page = chromeCtx.newPage();

        // a bunch of other interesting options
        chromeCtx.clearCookies();
        chromeCtx.clearPermissions();
        // and many many more!


        // Step 6: Start the clicking
        // ----------------------------------------

        // works with local files too - "file:///C:/website/HomePage.html"
        page.navigate("https://www.google.com/");
        System.out.println(page.url());
        page.click("text=I agree"); // is it case-sensitive?
        page.fill("//input[@type='text']", "test");
        page.click("//input[@type='submit']");
        // + dozens of other methods
        System.out.println(page.url());

        pw.close();
        pw2.close();
    }
}
