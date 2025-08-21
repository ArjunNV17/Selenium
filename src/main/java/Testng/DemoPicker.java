package Testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DemoPicker {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testDatePicker() {
        driver.get("https://demoqa.com/date-picker");

        // Date Picker
        driver.findElement(By.id("datePickerMonthYearInput")).clear();
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("08/25/2025");
        System.out.println("Date set successfully");
    }

    @Test
    public void testColorPicker() {
        driver.get("https://demoqa.com/automation-practice-form");

        // Example: selecting Date of Birth (acts like picker)
        driver.findElement(By.id("dateOfBirthInput")).clear();
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("20 Aug 1998");
        System.out.println("DOB set successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}