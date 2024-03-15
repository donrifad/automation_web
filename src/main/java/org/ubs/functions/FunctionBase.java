package org.ubs.functions;

import org.apache.log4j.Logger;
import org.ubs.data.SearchedItem;
import org.ubs.common.BrowserTypes;
import org.ubs.pages.DriverBase;
import org.ubs.utils.DriverSetupUtil;
import org.ubs.utils.PropertyReader;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionBase {
    public static Logger log = Logger.getLogger(FunctionBase.class.getName());

    /**
     * Get the driver
     * Set the driver to driver base page
     */
    public static void startBrowser() {
        if (PropertyReader.getProperty("browser.type").equalsIgnoreCase(String.valueOf(BrowserTypes.Chrome))) {
            DriverBase.setDriver(DriverSetupUtil.getDriver(BrowserTypes.Chrome));
            log.info("...... starting browser for testing ... " + PropertyReader.getProperty("browser.type"));
            System.out.println("...... starting browser for testing ... " + PropertyReader.getProperty("browser.type"));
        } else if (PropertyReader.getProperty("browser.type").equalsIgnoreCase("firefox")) {
            DriverBase.setDriver(DriverSetupUtil.getDriver(BrowserTypes.Firefox));
            log.info("...... starting browser for testing ... " + PropertyReader.getProperty("browser.type"));
            System.out.println("...... starting browser for testing ... " + PropertyReader.getProperty("browser.type"));
        } else {
            log.info("lease provide a valid browser name");
            System.out.println("Please provide a valid browser name");
        }
    }

    public static void closeApp() {
        log.info("closing the app");
        DriverBase.quitDriver();
    }

    public static void loadUrl(String url) {
        log.info("loading  the app: "+url);
        DriverBase.loadWebPage(url);
    }

}


