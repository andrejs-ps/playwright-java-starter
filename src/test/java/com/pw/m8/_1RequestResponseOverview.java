package com.pw.m8;

import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;
import com.pw.ScriptBase;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class _1RequestResponseOverview extends ScriptBase {

    @Test
    public void responseApiDemo() {

        // not status code from a local file, naturally
        Response r = page.navigate(home);
        System.out.println(r.status()); // 0

        // but plenty from a resource served by a server
        Response r2 = page.navigate("https://playwright.dev");

        System.out.println(r2.url());
        System.out.println(r2.status());
        System.out.println(r2.ok()); // true if in the 200-299 range
        System.out.println(r2.headers());


        System.out.println(r2.body()); // hash
        System.out.println("Converted byte array");
        System.out.println(new String(r2.body(), StandardCharsets.UTF_8)); // byte[]
        System.out.println("Convenience method");
        System.out.println(r2.text());
    }

    @Test
    public void requestApiDemo() {

        Response response = page.navigate("https://playwright.dev/");

        // you get to the issued request via response
        Request request = response.request();

        System.out.println(request.headers());
        System.out.println(request.method());
        System.out.println(request.postData()); // null
    }

    @Test
    public void monitorHttpTrafficDemo() {

        // Option 1: just print
        page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
        page.onResponse(response -> System.out.println("<<" + response.status() + " " + response.url()));

        // Option 2: save to a list and do something with it if necessary
        List<String> requests =  new ArrayList<>();
        List<String> responses = new ArrayList<>();
        page.onRequest(request -> requests.add(request.method() + " " + request.url()));
        page.onResponse(response -> responses.add(response.status() + " " + response.url()));

        page.navigate("https://playwright.dev/");

        System.out.println("============== Printing Requests ==============");
        System.out.println(requests);
        System.out.println("============== Printing Responses ==============");
        System.out.println(responses);
    }
}
