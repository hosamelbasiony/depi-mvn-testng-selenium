package com.depi2.prj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected WebElement find( By locator) {
        return driver.findElement(locator);
    }

    protected void click( By locator) {
        find(locator).click();
    }

    protected void sendKeys( By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected String getText( By locator) {
        return find(locator).getText();
    }

    protected boolean isDisplayed( By locator) {
        return find(locator).isDisplayed();
    }

    protected void waitForElementToBeVisible( By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
