package org.ubs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.ubs.common.GlobalConstants;
import org.ubs.functions.AmazonFilters;
import org.ubs.functions.AmazonHome;
import org.ubs.functions.FunctionBase;
import org.ubs.utils.PropertyReader;

import java.util.List;

public class AmazonSearchTest extends TestBase{
    public String department = PropertyReader.getProperty("search.department");
    public String category = PropertyReader.getProperty("search.category");
    public String subCategory = PropertyReader.getProperty("search.subcategory");

    public List<String> listFilters = List.of(PropertyReader.getProperty("search.filters").split(","));

    /**
     * Setting up the browser
     */
    @BeforeMethod
    public void setUp() {
        FunctionBase.startBrowser();
        AmazonHome.loadUrl(GlobalConstants.AMAZON);
    }


    @Test(priority = 1)
    public void testAmazonSearchFilters() {
        AmazonHome.navigateToMenu(department, category, subCategory);
        AmazonFilters.searchFor(listFilters.get(0),listFilters.get(1),
                listFilters.get(2), listFilters.get(3),listFilters.get(4));
        AmazonHome.isMessageDisplayed("Try checking your spelling or use more general terms");

    }

}
