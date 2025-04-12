package com.depi2prj.tests;

import com.depi2.prj.pages.BasePage;
import com.depi2.prj.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    protected BasePage basePage;

    protected LoginPage loginPage;

    protected final String baseUrl = "https://todo-testing.tarqim.info";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.get(baseUrl);

//        basePage = new BasePage();
//        basePage.setDriver(driver);

//        loginPage = new LoginPage();
//        loginPage.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(baseUrl);
        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
    }

    @AfterMethod
    public void takeScreenshotOfFailures(ITestResult testRsult) {
        if( ITestResult.FAILURE == testRsult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" + testRsult.getName() + ".png");
            try {
                FileHandler.copy(src, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}