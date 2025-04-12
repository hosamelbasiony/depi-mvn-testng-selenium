package com.depi2prj.tests;

import com.depi2.prj.pages.SignupPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class SignupPageTest extends BaseTest {
    SignupPage signupPage = new SignupPage();

    private String email = "";
    private final String name = "Depi2 Cy User";
    private final String password = "Depi@123";

    @BeforeClass
    public void verifyTitle() {
        Instant currentTimestamp = Instant.now();
        this.email = "hosam" + currentTimestamp.getEpochSecond() + "@gmail.com";
    }

    @Test(priority = 1)
    public void verifyFailedSignupWithInvalidPassword() {

        signupPage.navigateTo(this.baseUrl + "/register");

        signupPage.waitForSignupPage();

        System.out.println("Running test case verifyFailedSignupWithInvalidPassword ...");
        signupPage.typeEmail(this.email);
        signupPage.typePassword("123");
        signupPage.typeName(this.name);
        signupPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(signupPage.driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(signupPage.getSignupErrorLocator()));

        Assert.assertTrue(errorMessage.isDisplayed(), "Signup success message is not displayed!");
    }

    @Test(priority = 2)
    public void verifySuccessfullSignupWithValidData() {

        signupPage.navigateTo(this.baseUrl + "/register");

        System.out.println("Running test case verifySuccessfullSignupWithValidData ...");
        signupPage.typeEmail(this.email);
        signupPage.typePassword(this.password);
        signupPage.typeName(this.name);
        signupPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(signupPage.driver, Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(signupPage.getSignupSuccessLocator()));

        Assert.assertTrue(successMessage.isDisplayed(), "Signup success message is not displayed!");
    }
}