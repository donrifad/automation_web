package org.ubs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.ubs.data.SearchedItem;

import java.util.ArrayList;
import java.util.List;

public class AmazonResultPage extends DriverBase{
    public static Logger log = Logger.getLogger(AmazonResultPage.class.getName());

    private String searchResultMsg = "//*[@id=\"search\"]//span[text()=\"MESSAGE\"]";
    private By  listSearchedItems = By.xpath("//*[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"]");

    private String itemDescription = "//div[@data-cel-widget=\"search_result_INDEX\"]//h2/a/span";

    private String itemPrice = "//div[@data-cel-widget=\"search_result_INDEX\"]//span[@class=\"a-price-whole\"]";




    public boolean isMessageDisplayed(String message){
        try {
            log.info("Checking the results");
            return isDisplayed(By.xpath(searchResultMsg.replaceAll("MESSAGE", message)));
        }
        catch (Exception e){
            log.error(e);
            return false;
        }
    }

    public List<SearchedItem> getListOfSearchedItems() {
        List<WebElement> listOfItems = findElements(listSearchedItems);
        List<SearchedItem> actualItems = new ArrayList<>();
        int i = 1;
        try {
            for (WebElement e : listOfItems) {
                SearchedItem item = new SearchedItem();
                String actualItemDescription = getText(By.xpath(itemDescription.replaceAll("INDEX", String.valueOf(i))));
                String actualItemPrice = getText(By.xpath(itemPrice.replaceAll("INDEX", String.valueOf(i))));
                item.setDescriptions(actualItemDescription);
                item.setPrice(actualItemPrice);
                actualItems.add(item);
                log.info("results{" + i + "} " + actualItemDescription + " and  price " + actualItemPrice);
                i++;
            }
        } catch (Exception e) {
            log.error(e);
        }

        return actualItems;
    }
}
