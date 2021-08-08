package com.pw.m8;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class _2SetHttpAuthentication {

    Playwright pw;
    Browser browser;
    String token = "your_valid_token";
    @Test
    public void setHttpAuthentication() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext ctx = browser.newContext(new Browser.NewContextOptions()
//                .setHttpCredentials("usr", "pwd")
                .setExtraHTTPHeaders(Map.of("Authorization", "token " + token))
        );

        Page page = ctx.newPage();
        Response response = page.navigate("https://api.github.com/user");
        System.out.println(response.text());
        Assertions.assertEquals(401, response.status()); // 200 with valid token
    }

    @AfterEach
    public void cleanup() {
        browser.close();
        pw.close();
    }
}
