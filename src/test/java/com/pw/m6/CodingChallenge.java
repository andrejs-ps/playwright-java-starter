package com.pw.m6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UsePlaywright
public class CodingChallenge {

    @Test
    // Capture all uncaught errors (exceptions)
    void codingChallenge(Page page) {

        page.navigate(HOME_WEB);

        // 1) create a list



        // 2) Create the handler that adds errors to a list



        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Register")).click();


        // 3)  if list not empty - fail test (use plain JUnit assertion)

    }
}
