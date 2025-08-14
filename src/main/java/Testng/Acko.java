package Testng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Acko{
    WebDriver driver;

    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void signUpOrGetQuote() {
        driver.get("https://www.acko.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Sign Up']"))).click();

      
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Full name']"))).sendKeys("Arjun NV");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Mobile number']"))).sendKeys("7356787806");

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Sign Up']"))).click();
    }

    @AfterClass
	public void Login(){
	
		driver.get("https://www.acko.com/");
		System.out.println("performing Login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']"))).click();
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=]"))).sendKeys("7356787806");
		  // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter a valid phone number']"))).sendKeys(""); 
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']"))).click();
        }
    }

