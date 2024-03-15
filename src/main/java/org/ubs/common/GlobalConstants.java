package org.ubs.common;

public class GlobalConstants {
    public static final String BROWSER = System.getProperty("browser.type", "chrome");
    public static int DEFAULT_TIMEOUT = Integer.parseInt(System.getProperty("test.timeout", "20"));
    public static final String AMAZON = System.getProperty("amazon.url", "https://www.Amazon.co.uk");

}
