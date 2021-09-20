package com.pw.m9;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1Verification extends ScriptBase {

    @Test
    public void handlingConsoleMessages() {

        // all console messages
        page.onConsoleMessage(msg -> {
            System.out.println("Console message found: \n" + msg.type() + ": "  + msg.text());
        });


        // filter for some
        page.onConsoleMessage(msg -> {
            if ("error".equals(msg.type()))
                System.out.println("Error text: " + msg.text());
                Assertions.fail("Error found. Test failed!");
                // OR
                throw new RuntimeException("Error found. Test failed!");
        });

        page.navigate("https://github.com/andrejs-p"); // incorrect URL
    }
}
