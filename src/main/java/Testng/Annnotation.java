package Testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annnotation {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Start the suite");
    }

    @BeforeTest
    public void beforeTEST() {
        System.out.println("Preparing the environment");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Launching the browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigating to orangeHRM login Page");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(priority = 1)
    public void verifyPage() {
        System.out.println("Page is displayed");
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title is mismatched");
    }

    @Test(priority = 2)
    public void LoginTest() {
        System.out.println("Performing Login");

        // Wait for and enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

        // Wait for and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");

        // Wait for and click Login button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();

        // Validate title after login
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched after login");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Logging out from OrangeHRM");

        try {
            // Wait for and click profile dropdown
            wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("p.oxd-userdropdown-name"))).click();

            // Wait for and click logout option
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Logout']"))).click();

            // Confirm we’re back at the login page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        } catch (Exception e) {
            System.out.println("Logout skipped (possibly already at login page).");
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Browser will remain open after suite");
        // ❌ Removed driver.quit();
    }

    @AfterTest
    public void afterTEST() {
        System.out.println("After test method should work");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite method should work");
    }
}
