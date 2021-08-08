package com.pw.m5;

import com.microsoft.playwright.Keyboard;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _4PressOptions extends ScriptBase {

    @Test
    public void pressOptions() {

        page.navigate(home);
        // enter with typo
        page.fill("#exampleFormControlInput1", "myEmail@inbox.con");
        Keyboard kb = page.keyboard();
        kb.press("Backspace");
        kb.press("m");
        // below three actions are equivalent to .selectOption()
        page.focus("#contactReason");
        kb.press("ArrowDown");
        kb.press("ArrowDown");

        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));
    }
}
