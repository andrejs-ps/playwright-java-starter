package com.pw.m5;

import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _3SelectOptions extends ScriptBase {

    @Test
    public void selectScenario() {

      page.navigate(home);
      page.selectOption("id=contactReason", "I'm just bored"); // fails, must match <option value="xyz">
//    page.selectOption("id=contactReason", "Bored");
      assertTrue(page.isVisible("text=OK, but please make it interesting"));
    }
}
