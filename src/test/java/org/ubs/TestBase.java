package org.ubs;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.ubs.functions.FunctionBase;

import java.util.Date;

public class TestBase {
    public static Logger log = Logger.getLogger(TestBase.class.getName());

    @BeforeMethod
    public void start(){
        Date d = new Date();
        System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/ubs_automation/src/main/resources/properties/log4j.properties");
        log.info("Starting the test");
    }

    @AfterMethod
    public void closeBrowser(){
        FunctionBase.closeApp();
    }
}
