package com.pw.m6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class Dialogs {

    String name = "Sofia";

    @Test
    void dialogDefaultHandling(Page page) {
       page.navigate(HOME_WEB);

       var nameInput = page.getByLabel("First name");
       nameInput.fill(name);

       assertThat(nameInput).hasValue(name);

       page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear")).click();
       assertThat(nameInput).hasValue(name);
    }

    @Test
    void dialogAccept(Page page) {

    }
}
