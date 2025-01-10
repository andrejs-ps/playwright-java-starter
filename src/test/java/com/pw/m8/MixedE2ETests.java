package com.pw.m8;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class MixedE2ETests {

    APIRequestContext apiContext;

    String repoName = "Playwright-test-repo";
    String username = "your_username";
    String token = "your_token";

    @BeforeEach
    void createRepo(Playwright pw) {


    }

    @Test
    void workWithNewlyCreatedRepo(Page page) {

        page.navigate(String.format("https://github.com/%s?tab=repositories", username));


    }

    @AfterEach
    void deleteRepo() {


    }
}
