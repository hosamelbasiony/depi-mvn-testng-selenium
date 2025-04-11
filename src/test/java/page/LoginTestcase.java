package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.login;

import java.time.Duration;

public class LoginTestcase extends Base_test {
    login LP;

    // // DataProvider لقراءة بيانات تسجيل الدخول من ملف Excel
    // @DataProvider(name = "loginData")
    // public Object[][] getData(Method method) {
    //     String excelPath = "C:\\Users\\TATA\\Desktop\\users.xlsx"; // مسار ملف Excel
    //     ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

    //     int rowCount = excel.getRowCount();
    //     int colCount = excel.getColCount();

    //     Object data[][] = new Object[rowCount - 1][colCount];

    //     for (int i = 1; i < rowCount; i++) { // تخطي الصف الأول (العناوين)
    //         for (int j = 0; j < colCount; j++) {
    //             data[i - 1][j] = excel.getCellData(i, j);
    //         }
    //     }
    //     return data;
    // }

    // حالة الاختبار باستخدام البيانات من DataProvider
    @Test(priority = 1)
    public void test_login_with_all_users() {

        String username = "standard_user";
        String password = "secret_sauce";

        LP = new login(base_driver);

        // التوجه إلى صفحة تسجيل الدخول
        base_driver.get("https://www.saucedemo.com/");
        
        System.out.println("Test case goto https://www.saucedemo.com");

        // تسجيل الدخول باستخدام البيانات المقدمة
        LP.setusername(username);
        LP.setpassword(password);
        LP.clickonlogin();

        // التحقق من نتيجة تسجيل الدخول بناءً على اسم المستخدم
        if (username.equals("locked_out_user")) {
            // التحقق من رسالة الخطأ الخاصة بالمستخدم المحظور
            WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
            By errorMessage = By.xpath("//h3[@data-test='error']");
            String actualErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
            Assert.assertEquals(actualErrorMessage, "Epic sadface: Sorry, this user has been locked out.");
        } else {
            // التحقق من نجاح تسجيل الدخول
            WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
            By inventoryContainer = By.id("inventory_container"); // العنصر الذي يشير إلى صفحة المنتجات
            boolean isLoginSuccessful = wait.until(ExpectedConditions.presenceOfElementLocated(inventoryContainer)).isDisplayed();

            Assert.assertTrue(isLoginSuccessful, "تسجيل الدخول غير ناجح للمستخدم: " + username);
        }
    }

    public static class Base_test {
        WebDriver base_driver;
        @BeforeClass
        public void beforecless(){

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            base_driver=new ChromeDriver();
            base_driver.get("https://www.saucedemo.com/");
        }

        @AfterClass
        public void methodName() {
            base_driver.quit();

        }


    }
}