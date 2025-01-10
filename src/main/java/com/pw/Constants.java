package com.pw;

public class Constants {

    // < Java 18
    public static final String BASE = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";
    public static final String HOME = BASE + "index.html";
    public static final String SAVINGS = BASE + "savings.html";

    // Since Java 18: jwebserver (Simple HTTP Server)
    public static final String BASE_WEB = "http://localhost:8000/";
    public static final String HOME_WEB = BASE_WEB + "index.html";
    public static final String SAVINGS_WEB = BASE_WEB + "savings.html";
}
