package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.time.Instant;

public class TestCasesAutomation {
    WebDriver driver;
    String baseUrl = "https://todo-testing.tarqim.info";
    String driverPath = "C:\\Users\\HOSAM\\Desktop\\DSKTOP_LT\\DEPI2-GRADUATION-PROJECT\\chrome-win64\\chrome.exe";
    String loginTitlelocator = "//h1[text()='DEPI-2 TODOS']";
    String loginEmaillocator = "//input[@data-cy='email']";
    String loginPasswordlocator = "//input[@data-cy='password']";
    String loginNamelocator = "//input[@data-cy='name']";
    String loginButtonlocator = "//button[@data-cy='register']";
    String loginSuccesslocator = "//span[@class='success-msg']";
    String email = "";
    String name = "Depi2 Cy User";
    String password = "Depi@123";

    String signupSuccesslocator = "//span[contains(text(),'User Registered')]"; // "User Registered Redirecting";

    @Test(priority = 0)
    void setup() {
        // Setup code here
        System.out.println("Setting up test cases...");
//        System.setProperty("webdriver.firefox.driver", driverPath);
        
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        System.out.println("Navigated to: " + baseUrl);
        System.out.println("Browser window maximized.");
        System.out.println("Driver path: " + driverPath);
        System.out.println("Driver initialized: " + driver);
        System.out.println("Driver class: " + driver.getClass());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Instant currentTimestamp = Instant.now();
        email = "hosam" + currentTimestamp.getEpochSecond() + "@gmail.com";
    }

    @Test(priority = 1)
    void verifyLoginTitle() {

        System.out.println("Running test case 1...");

        driver.get(baseUrl);

        // Test case 1 code here
        String expectedTitle = "DEPI Todos";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");

        System.out.println("Title does match ...");

        // Additional assertions or actions can be added here
        String loginTitle = "DEPI-2 TODOS";
        String loginTitleActual = driver.findElement(By.xpath(loginTitlelocator)).getText();

        Assert.assertEquals(loginTitle, loginTitleActual, "Login Title does not match!");
        System.out.println("Login Title does match ...");

        driver.quit();
    }

//    @AfterMethod
//    void teardown() {
//        // Teardown code here
//        System.out.println("Tearing down test cases...");
//        driver.quit();
//    }
}
