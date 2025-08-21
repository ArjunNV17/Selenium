package Testng;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DemoPopup {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testPopup() {
        driver.get("https://demoqa.com/browser-windows");

        // Open new tab
        driver.findElement(By.id("tabButton")).click();

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Child window text: " + driver.findElement(By.id("sampleHeading")).getText());
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}