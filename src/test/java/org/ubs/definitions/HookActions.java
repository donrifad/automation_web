package org.ubs.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import org.ubs.functions.FunctionBase;
import org.ubs.pages.DriverBase;

import java.util.Date;


public class HookActions {
    public static Logger log = Logger.getLogger(HookActions.class.getName());

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("Failed Scenario Taking Screen Shot");
            TakesScreenshot ts = (TakesScreenshot) DriverBase.getDriver();
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", scenario.getId());
        }
        FunctionBase.closeApp();
        log.info("Closing the scenario"+scenario.getName());

    }

    @Before
    public static void testStart(Scenario scenario){
        Date d = new Date();
        System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/properties/log4j.properties");
        log.info("Starting the scenario"+scenario.getName());
    }
}
