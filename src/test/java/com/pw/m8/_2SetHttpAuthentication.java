package com.pw.m8;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;

public class _2SetHttpAuthentication {

    Playwright pw;
    Browser browser;
    String token = "real_token_goes_here";
    @Test
    public void setHttpAuthentication() {

        pw = Playwright.create();
        browser = pw.chromium().launch();

        // --------------- UI part ---------------
        BrowserContext uiContext = browser.newContext(
                new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json"))
        );

        Page uiPage = uiContext.newPage();
        uiPage.navigate("https://github.com/andrejs-ps");
        Assertions.assertTrue(uiPage.isVisible("text=Repositories 10"));


        // --------------- Web API part - cross-check ---------------
        BrowserContext ctx = browser.newContext(new Browser.NewContextOptions()
//                .setHttpCredentials("usr", "pwd")
                .setExtraHTTPHeaders(Map.of("Authorization", "token " + token))
        );

        Page webApiPage = ctx.newPage();
        Response response = webApiPage.navigate("https://api.github.com/user");
        System.out.println(response.text());
        Assertions.assertEquals(200, response.status()); // 200 with valid token, 401 otherwise
        Assertions.assertTrue(response.text().contains("\"public_repos\": 10"));
    }

    @AfterEach
    public void cleanup() {
        pw.close();
    }
}
