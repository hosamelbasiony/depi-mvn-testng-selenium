package com.depi2.prj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    private String email = "hoss@home.com";
    private String name = "Depi2 Cy User";
    private String password = "ASDasd@123";

    private By loginTitlelocator = By.xpath("//h1[text()='DEPI-2 TODOS']");
    private By loginEmaillocator = By.xpath("//input[@data-cy='email']");
    private By loginPasswordlocator = By.xpath("//input[@data-cy='password']");
    private By loginNamelocator = By.xpath("//input[@data-cy='name']");
    private By loginButtonlocator = By.xpath("//button[text()='Login']");
    private By loginSuccesslocator = By.xpath("//span[contains(@class,'success-msg')]");
    private By loginErrorLocator = By.xpath("//span[contains(@data-cy,'registration-error')]");

    private By loginNameErrorlocator = By.xpath("//span[text()='Name should be min 5 characters..']");
    private By loginEmailErrorlocator = By.xpath("//span[text()='Email is not valid']");

    public LoginPage() {
        super();
    }

    public void typeEmail() {
        sendKeys(loginEmaillocator, email);
    }

    public void typeWrongEmail() {
        sendKeys(loginEmaillocator, "wrongemail");
    }

    public void typePassword() {
        sendKeys(loginPasswordlocator, password);
    }
    public void typeWrongPassword() {
        sendKeys(loginPasswordlocator, "wrongpassword");
    }

    public void clickLoginButton() {
        click(loginButtonlocator);
    }

    public boolean verifyTitle() {
        String expectedTitle = "DEPI Todos";
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public By getLoginSuccessLocator() {
        return loginSuccesslocator;
    }
    public By getLoginErrorLocator() {
        return loginErrorLocator;
    }

    public void waitForLoginPage() {
        waitForElementToBeVisible(loginTitlelocator);
    }
}