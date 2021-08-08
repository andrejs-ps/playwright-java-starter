package com.pw.m6;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import com.pw.ScriptBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _2Download extends ScriptBase {

    @BeforeEach
    @Override
    protected void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
//        context = browser.newContext(); // won't work without setAcceptDownloads()
        page = context.newPage();
        page.setViewportSize(1920, 1080);
        page.setDefaultTimeout(3_000);
    }

    @Test
    public void downloadTestWithHandler() {

        page.navigate(home);

        page.onDownload(download -> {
            System.out.println(download.path());
            // WORKS!
            download.saveAs(Paths.get(new File("C:\\Users\\Andre\\PlaywrightDownloads\\downloaded.zip").toURI()));
        });

        page.click("text=Download ZIP");
        // load the PDF and do something with it using standard I/O code
    }
    @Test
    public void downloadTestWithWaitForEvent() {
        page.navigate(home);

        // Wait for the download to start
        Download download = page.waitForDownload(() -> {
            // Perform the action that initiates download
            page.click("text=Download ZIP");
        });

        Path path = download.path();
        System.out.println(path);
        // load the PDF and do something with it using standard I/O code
    }
}
