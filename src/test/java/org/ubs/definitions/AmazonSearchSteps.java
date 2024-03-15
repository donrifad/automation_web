package org.ubs.definitions;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.ubs.TestBase;
import org.ubs.data.SearchedItem;
import org.ubs.functions.AmazonFilters;
import org.ubs.functions.AmazonHome;
import org.ubs.functions.FunctionBase;

import java.util.List;


public class AmazonSearchSteps extends TestBase {
    public static Logger log = Logger.getLogger(AmazonSearchSteps.class.getName());

    @Given("User is on Amazon page {string}")
    public void user_is_on_amazon_page(String url) {
        FunctionBase.startBrowser();
        FunctionBase.loadUrl(url);
        log.info("User is on Amazon page");

    }


    @When("^User Navigate to Main Category as (.+) and Subcategory as (.+) and (.+)$")
    public void userNavigateToMainCategoryAsDepartmentAndSubcategoryAsCategoryAndSubcategory(String department, String category, String subCategory) {
        log.info("Navigate to Main Category"+ department+":"+category+":"+subCategory);
        AmazonHome.navigateToMenu(department, category, subCategory);
    }

    @And("^User Filters By Year as (.+) and Brand as (.+) and Camera as (.+) and Price as (.+) and (.+)$")
    public void userUserFiltersByYearAsYearAndBrandAsBrandAndCameraAsCameraAndPriceAsMinPriceAndMaxPrice(String modelYear, String brand, String camera, String minPrice, String maxPrice) {
        log.info("Navigate to filters: "+ modelYear+":"+brand+":"+camera);
        AmazonFilters.searchFor(modelYear, brand, camera, minPrice, maxPrice);
    }

    @Then("User should be able see the results as {string}")
    public void userShouldBeAbleSeeTheResultsAs(String message) {
        log.info("Verifying "+ message);
        Assert.assertTrue(AmazonHome.isMessageDisplayed(message),"Invalid Search Results");
    }

    @Then("^User should be able see the results as (.+) and Price as (.+) and (.+)$")
    public void userShouldBeAbleSeeTheResultsAsBrandAndPriceAsMinPriceAndMaxPrice(String brand, String minPrice, String maxPrice) {
        log.info("Verifying the list");
        verifySearchResults(brand,minPrice,maxPrice);
    }

    @And("Close the browser")
    public void close_the_browser() {
        log.info("Closing the browser");
        FunctionBase.closeApp();
    }

    public static void verifySearchResults(String brand, String minPrice, String maxPrice){
        SoftAssert softAssert = new SoftAssert();
        List<SearchedItem> listActualItems = AmazonHome.getSearchedResult();
        for(int i=0; i<listActualItems.size(); i++){
            softAssert.assertTrue(listActualItems.get(i).getDescriptions().toUpperCase().contains(brand.toUpperCase()),
                    "Error on item:" +listActualItems.get(i).getDescriptions());
            softAssert.assertTrue(Integer.parseInt(minPrice)<=Integer.parseInt(listActualItems.get(i).getPrice()),"Error on PRICE : "+listActualItems.get(i).getPrice());
            softAssert.assertTrue(Integer.parseInt(maxPrice)>=Integer.parseInt(listActualItems.get(i).getPrice()),"Error on PRICE : "+listActualItems.get(i).getPrice());
        }
        softAssert.assertAll();
    }


}

