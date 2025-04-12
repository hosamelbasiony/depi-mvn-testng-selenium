package com.depi2.prj.pages;

import org.openqa.selenium.By;

public class SignupPage extends BasePage {


    private String email = "hoss@home.com";
    private String name = "Depi2 Cy User";
    private String password = "ASDasd@123";

    private By signupTitlelocator = By.xpath("//h1[text()='DEPI-2 TODOS']");
    private By loginEmaillocator = By.xpath("//input[@data-cy='email']");
    private By loginPasswordlocator = By.xpath("//input[@data-cy='password']");
    private By loginNamelocator = By.xpath("//input[@data-cy='name']");
    private By signupButtonlocator = By.xpath("//button[text()='Register']");
    private By signupSuccesslocator = By.xpath("//span[contains(@class,'success-msg')]");
    private By signupErrorLocator = By.xpath("//span[contains(@data-cy,'registration-error')]");

    private By loginNameErrorlocator = By.xpath("//span[text()='Name should be min 5 characters..']");
    private By loginEmailErrorlocator = By.xpath("//span[text()='Email is not valid']");

    public SignupPage() {
        super();
    }

    public void typeEmail(String email) {
        sendKeys(loginEmaillocator, email);
    }

    public void typePassword(String password) {
        sendKeys(loginPasswordlocator, password);
    }

    public void typeName(String name) {
        sendKeys(loginNamelocator, name);
    }

    public void clickLoginButton() {
        click(signupButtonlocator);
    }

    public boolean verifyTitle() {
        String expectedTitle = "DEPI Todos";
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public By getSignupSuccessLocator() {
        return signupSuccesslocator;
    }
    public By getSignupErrorLocator() {
        return signupErrorLocator;
    }

    public void waitForSignupPage() {
        waitForElementToBeVisible(signupTitlelocator);
    }
}