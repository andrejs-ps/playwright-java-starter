package com.pw.m6;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.pw.Constants.HOME_WEB;


@UsePlaywright
public class BrowserStorage {

    String name = "Andrejs";

    @Test
    void storageUiPerspective(Page page) {

        page.navigate(HOME_WEB);

        var nameInput = page.getByLabel("First name");
        nameInput.fill(name);
        page.reload();
        assertThat(nameInput).hasValue("");

        nameInput.fill(name);
        page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Save Input")).click();
        page.reload();
        assertThat(nameInput).hasValue(name);
    }
}
