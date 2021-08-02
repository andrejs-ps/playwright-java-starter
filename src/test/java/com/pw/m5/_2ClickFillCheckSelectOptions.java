package com.pw.m5;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class _2ClickFillCheckSelectOptions extends ScriptBase {

    @Test
    public void clickOptions() {

        page.navigate(home);
        page.click("text=Submit", new Page.ClickOptions().setClickCount(2));
        page.click("text=Submit", new Page.ClickOptions().setButton(MouseButton.RIGHT));

        // also this
        page.click("#item", new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL)));
        page.click("#item", SHIFT);
    }

    public static final Page.ClickOptions SHIFT = new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.SHIFT));

    @Test
    public void fillOptions() {

        page.navigate(home);
        page.fill("id=exampleMessage", "My message to you...", new Page.FillOptions().setForce(true));
    }

    @Test
    public void pressOptions() {

        page.navigate(home);
        page.press("Selector", "Key");
    }

}
