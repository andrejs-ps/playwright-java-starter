package com.pw.m5;

import com.microsoft.playwright.Locator;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;


public class _5LocatorExample extends ScriptBase {

    @Test
    public void fillOptions() {

        page.navigate(home);
        Locator input = page.locator(".form-control");

        System.out.println(input.count());

        input.first().fill("first");
        input.last().fill("last");
        input.nth(2).fill("second");
    }
}
