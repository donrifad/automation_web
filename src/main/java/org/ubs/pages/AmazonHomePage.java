package org.ubs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class AmazonHomePage extends DriverBase{
    public static Logger log = Logger.getLogger(AmazonHomePage.class.getName());

    private By menuAll = By.xpath("//*[@id=\"nav-hamburger-menu\"]/span");
    private String menuDepartments = "//*[@id=\"hmenu-content\"]//div[contains(text(),\"DEPARTMENT\")]";

    private String sideSubMenu = "//*[@id=\"hmenu-content\"]//a[contains(text(),\"SUBMENU\")]";


    private String subCategory = "//*[@title=\"CATEGORY\"]";

    private By header = By.xpath("//h1[contains(text(),\"Featured categories\")]");

    private By cookies = By.id("sp-cc-accept");


    public void navigateTo(String departments, String subMenu, String category){
        try {
            log.info("Searching via "+departments);
            if (isDisplayed(cookies))
                clickElement(cookies);
            clickElement(menuAll);
            waitTillElementLoaded(By.xpath(menuDepartments.replaceAll("DEPARTMENT", departments)), 30);
            moveToAndClick(By.xpath(menuDepartments.replaceAll("DEPARTMENT", departments)));
            waitTillElementLoaded(By.xpath(sideSubMenu.replaceAll("SUBMENU", subMenu)), 30);
            moveToAndClick(By.xpath(sideSubMenu.replaceAll("SUBMENU", subMenu)));
            clickElement(By.xpath(subCategory.replaceAll("CATEGORY", category)));
            waitTillElementLoaded(header, 30);
        }
        catch (Exception e){
            log.error(e);
        }
    }

}
