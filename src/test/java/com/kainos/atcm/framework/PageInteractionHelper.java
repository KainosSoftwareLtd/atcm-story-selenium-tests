package com.kainos.atcm.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class PageInteractionHelper {
    
    public WebDriver driver;

    public PageInteractionHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait driverWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new WebDriverWait(driver, 30);
    }

    public void clickOnElement(By locator) {
        waitUntilClickable(locator).click();
    }

    public WebElement waitUntilClickable(final By locator) {
        return driverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> getElements(By locator) {
        return waitUntilPresent(locator).findElements(locator);
    }

    public WebElement waitUntilPresent(By locator) {
        return driverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getText(By locator) {
            return getElement(locator).getText();
    }

    public WebElement getElement(By locator) {
        return waitUntilPresent(locator);
    }
}
