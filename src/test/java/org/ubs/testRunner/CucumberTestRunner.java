package org.ubs.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@smoke", features = {"src/test/resources/features/AmazonSearch.feature"},
        glue = {"org/ubs/definitions"},
        plugin = {"pretty","html:test_output/htmlreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberTestRunner  extends AbstractTestNGCucumberTests {
}
