package com.pw.m5;

import com.microsoft.playwright.Page;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class _1NavigationOptions extends ScriptBase {

    @Test
    public void navigationOptions() {

        page.navigate(home, new Page.NavigateOptions()
//                .setTimeout(1) // Max operation time in ms, default 30s, 0 to disable timeout
//                https://developer.mozilla.org/en-US/docs/Web/API/Window/DOMContentLoaded_event
//                https://developer.mozilla.org/en-US/docs/Web/API/Window/load_event
//                  consider operation to be finished when there are no network connections for at least 500 ms
//                .setWaitUntil(WaitUntilState.LOAD) // default
//                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
//                .setWaitUntil(WaitUntilState.NETWORKIDLE)
        );
        assertEquals(page.title(), "Home Page");
    }
}
