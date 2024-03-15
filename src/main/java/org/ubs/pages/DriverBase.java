package org.ubs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.ubs.common.GlobalConstants.DEFAULT_TIMEOUT;

public class DriverBase {

    static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverBase.driver = driver;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    protected void enterText(By by, String text) {
        findElement(by, DEFAULT_TIMEOUT).sendKeys(text);
    }

    protected void enterText(By by, CharSequence... keysToSend) {
        findElement(by, DEFAULT_TIMEOUT).sendKeys(keysToSend);
    }

    protected void clearText(By by) {
        findElement(by,  DEFAULT_TIMEOUT).clear();
    }

    protected void clickElement(By by) {
        findElement(by, DEFAULT_TIMEOUT).click();
    }

    protected WebElement findElement(By by, int defaultTimeout) {
        return driver.findElement(by);
    }

    public WebElement waitTillElementLoaded(By by, long timeout) {
        return (WebElement) (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitTillElementDisappear(By by, long timeout) {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.invisibilityOf(findElement(by, (int) DEFAULT_TIMEOUT)));
    }

    public String getText(By by) {
        try {
            return this.findElement(by, (int) DEFAULT_TIMEOUT).getText();
        } catch (Exception var3) {
            return "Not displayed";
        }
    }

    public String getText(By by, int timeout) {
        try {
            return this.findElement(by, timeout).getText();
        } catch (Exception var3) {
            return "Not displayed";
        }
    }

    protected List<WebElement> findElements(By by) {
        try {
            return new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).ignoring(NoSuchElementException.class).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void moveToAndClick(WebElement element) {
        new Actions((driver)).moveToElement(element).click().perform();
    }

    public void moveToAndClick(By by) {
        new Actions((driver)).moveToElement(this.findElement(by,5)).click().perform();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void loadWebPage(String appUrl) {
        getWebDriver().get(appUrl);
    }

    protected boolean isDisplayed(By by) {
        try {
            return findElement(by, DEFAULT_TIMEOUT).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}
