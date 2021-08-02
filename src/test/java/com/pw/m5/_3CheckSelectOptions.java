package com.pw.m5;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

public class _3CheckSelectOptions extends ScriptBase {

    @Test
    public void checkScenario1() {

        page.navigate(home);
        page.check("");
    }

    @Test
    public void checkScenario2() {

        page.navigate(home);
        page.check("");
    }

    @Test
    public void checkOptions() {
        // no interesting options, so no mention
    }
}
