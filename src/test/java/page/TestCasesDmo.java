package page;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCasesDmo {

    @BeforeMethod
    public void start() {
        System.out.println("Test started");
    }

    @Test(priority = 1)
    public void testCase1() {
        System.out.println("Test case 1");
    }

    @Test(priority = 2)
    public void testCase2() {
        System.out.println("Test case 2");
    }

    @Test(priority = 3)
    public void testCase3() {
        System.out.println("Test case 3");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test tear down");
    }
}
