package page;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

    @BeforeMethod
    public void start() {
        System.out.println("Test started");
    }

    @Test(priority = 1)
    public void testCase1() {
        System.out.println("Test case 1");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test tear down");
    }
}
