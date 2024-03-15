package org.ubs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.ubs.common.BrowserTypes;
import org.ubs.common.GlobalConstants;
import org.ubs.pages.SideFilterPanel;

import java.util.concurrent.TimeUnit;

public class DriverSetupUtil {
    public static Logger log = Logger.getLogger(DriverSetupUtil.class.getName());

    /**
     * Initiate the driver
     * Return the driver
     * @param driverType
     * @return
     */
    public static WebDriver getDriver(BrowserTypes driverType) {
        WebDriver driver = null;
        try {
            if (driverType.equals(BrowserTypes.Chrome)){
                log.info("Setting up chrome driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (driverType.equals(BrowserTypes.Firefox)) {
                log.info("Setting up firefox driver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
       } catch (Exception e) {
            log.error(e);
            System.out.println("Error in driver  "+e.toString());
            System.exit(1);
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }

}
