package Testng;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File("screenshots/" + testName + ".png");
            FileUtils.copyFile(source, target);
            System.out.println("Screenshot saved: " + target.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
