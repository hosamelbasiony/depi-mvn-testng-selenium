package com.depi2prj.tests;

import com.depi2.prj.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void verifyTitle() {
        System.out.println("Running test case verifyTitle ...");
        Assert.assertTrue(loginPage.verifyTitle());
    }

//    @Test(priority = 2)
//    public void verifyFailedLoginWithInvalidEmail() {
//        loginPage.waitForLoginPage();
//
//        System.out.println("Running test case verifyFailedLoginWithInvalidEmail ...");
//        loginPage.typeWrongEmail();
//        loginPage.typePassword();
//        loginPage.clickLoginButton();
//
//        WebDriverWait wait = new WebDriverWait(loginPage.driver, Duration.ofSeconds(5));
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginErrorLocator()));
//
//        Assert.assertTrue(errorMessage.isDisplayed(), "Login success message is not displayed!");
//    }

    @Test(priority = 3)
    public void verifyFailedLoginWithInvalidPassword() {
        loginPage.waitForLoginPage();

        System.out.println("Running test case verifyFailedLoginWithInvalidPassword ...");
        loginPage.typeEmail();
        loginPage.typeWrongPassword();
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(loginPage.driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginErrorLocator()));

        Assert.assertTrue(errorMessage.isDisplayed(), "Login success message is not displayed!");
    }

    @Test(priority = 4)
    public void verifySuccessfulLogin() {
        loginPage.waitForLoginPage();

        System.out.println("Running test case verifySuccessfulLogin ...");
        loginPage.typeEmail();
//        loginPage.typeName();
        loginPage.typePassword();
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(loginPage.driver, Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginSuccessLocator()));

        Assert.assertTrue(successMessage.isDisplayed(), "Login success message is not displayed!");
    }

}