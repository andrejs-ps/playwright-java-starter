package com.pw.m6;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _4CustomJsExpressions extends ScriptBase {

    @Test
    public void localStorage() {
        page.navigate(home);
        Object obj = page.evaluate("() => window.localStorage.getItem('clapped')");
        assertNull(obj);

        page.click("#clap-image");
        String obj2 = (String) page.evaluate("() => window.localStorage.getItem('clapped')");
        assertTrue(Boolean.parseBoolean(obj2));
    }

    @Test
    public void jsExpression() {
        page.navigate(home);
        page.evalOnSelector("#hero-banner", "e => e.remove()");
        assertFalse(page.isVisible("#hero-banner"));
    }

    @Test
    // alternative to the above
    public void jsExpression2() {
        page.navigate(advantages);
        Object obj = page.evalOnSelectorAll(".feature",  "f => f.length");
        assertEquals(3, obj);

        // or if we know what type to expect
        int count = (int) page.evalOnSelectorAll(".feature",  "f => f.length");
        assertEquals(3, count);
    }

}
