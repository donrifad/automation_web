package org.ubs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SideFilterPanel  extends DriverBase {
    public static Logger log = Logger.getLogger(SideFilterPanel.class.getName());

    private String checkBoxFilter = "//li[@aria-label=\"FILTER\"]//input";

    private String checkBoxYearFilter = "//span[contains(text(),'Model Year')]//following::li//input[@aria-labelledby=\"MODEL_YEAR\"]";

    private By inputMinPrice = By.xpath("//*[@id=\"low-price\"]");
    private By inputMaxPrice = By.xpath("//*[@id=\"high-price\"]");

    private By btnGo = By.xpath("//span[normalize-space(text()) = 'Go']");

    public void searchFor(String modelYear, String brand, String camera, String minPrice,  String maxPrice) {
       try {
           log.info("Searching Item");
           moveToAndClick(By.xpath(checkBoxYearFilter.replaceAll("MODEL_YEAR", modelYear)));
           moveToAndClick(By.xpath(checkBoxFilter.replaceAll("FILTER", brand)));
           moveToAndClick(By.xpath(checkBoxFilter.replaceAll("FILTER", camera)));
           enterText(inputMinPrice, minPrice);
           enterText(inputMaxPrice, maxPrice);
           moveToAndClick(btnGo);
       }
       catch (Exception e){
           log.error("Searching Item error "+ e);
       }
    }


}
