package com.pw.m8;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class RequestResponseOverview {

    @Test
    void responseApiDemo(Page page) {

        Response r2 = page.navigate(HOME_WEB);  // if no jwebserver - use any public site

    }

    @Test
    void requestApiDemo(Page page) {

        Response response = page.navigate(HOME_WEB);


    }
}
