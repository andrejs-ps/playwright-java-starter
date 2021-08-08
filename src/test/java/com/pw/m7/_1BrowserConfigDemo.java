package com.pw.m7;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class _1BrowserConfigDemo {

    Playwright pw;
    Browser browser;

    @Test
    public void browserConfigDemo() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setChannel("chrome")
                // this is still deleted at the end of the test run
                .setDownloadsPath(Path.of(new File(System.getProperty("user.dir") + "\\src\\web\\downloads\\download.zip").toURI()))
                .setArgs(List.of("--start-maximized")) // or --start-fullscreen - doesn't work, asked in Slack
        );

        Page page = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true)).newPage();
//        page.setViewportSize(1920, 1080);

        page.navigate("https://github.com/andrejs-ps/cat-in-the-bag");
        page.click("get-repo");

        Download download = page.waitForDownload(() -> {
            page.click("text=Download ZIP");
        });

        // will persist
        download.saveAs(Path.of(new File(System.getProperty("user.dir") + "\\src\\web\\download2.zip").toURI()));

        Path path = download.path();
        System.out.println(path);
    }

    @AfterEach
    public void cleanup() {
        browser.close();
        pw.close();
    }
}
