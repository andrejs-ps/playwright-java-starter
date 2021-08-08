package com.pw.m7;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ColorScheme;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class _0ConfigReference {


    public static void main(String[] args) {

        var pw = Playwright.create(new Playwright.CreateOptions()
                                .setEnv(Map.of("var1", "key1")));

        // only WebSockets - won't be covering
        BrowserType chrome = pw.chromium();
        chrome.connect("", new BrowserType.ConnectOptions()
                .setHeaders(Map.of("k1", "v1")) // Additional HTTP headers to be sent with WEB SOCKET connect request. Optional.
                .setSlowMo(200)
                .setTimeout(1000) // Max time in millis to wait for the connection to be established
        );

        // Step 3: Create a Browser instance
        // Playwright scripts generally start with launching a browser instance and end with closing the browser.
        // Can be launched in headless (without a GUI) or headed mode.
        // ----------------------------------------
        Browser chromeBr2 = chrome.launch(new BrowserType.LaunchOptions()
                .setHeadless(false) // true by default (faster)
                .setSlowMo(1_000)  // Slows down operations. Useful to see what is going on.
                .setTimeout(5_000) // Max time in millis to wait for the browser instance to start
                .setChannel("chrome") // Can be "chrome", "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
                .setDownloadsPath(Path.of(URI.create("")))
                .setArgs(List.of("--start-maximized"))
        );
        // + other interesting setters

        // Launches browser that uses persistent storage located at {@code userDataDir}
        //  which stores browser session data like cookies and local storage
//        BrowserContext ctx = chrome.launchPersistentContext(Path.of(URI.create("")));

        // Step 4: Create a Browser Context
        // an isolated incognito-alike session within a browser instance - fast and cheap to create.
        // Recommended to run each test in its own new Browser Context
        // ----------------------------------------
        BrowserContext chromeCtx = chromeBr2.newContext(new Browser.NewContextOptions()
                .setUserAgent("")
                .setJavaScriptEnabled(false)
                .setBaseURL("https://github.com/microsoft/playwright-java")
                .setColorScheme(ColorScheme.DARK));
    }
}
