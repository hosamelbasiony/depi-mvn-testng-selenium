package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Base_test {
    WebDriver base_driver;
    @BeforeClass
    public void beforecless(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        base_driver=new ChromeDriver(options);
        base_driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void methodName() {
        base_driver.quit();

    }


}