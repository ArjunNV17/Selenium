package Testng;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class App {

	 WebDriver driver;
	 
	 @BeforeClass
		public void launchBrowser() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		 
	 }
	
	 @Test
	 public void registerNewUser() {
		 driver.get("https://demowebshop.tricentis.com/");
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/register']"))).click();
		 
	       System.out.println(driver.getTitle());
	       
	       driver.findElement(By.id("FirstName")).sendKeys("arjun");
	       driver.findElement(By.id("FirstName")).sendKeys("leo");
	       
	 }
	 
	 @Test
	 public void launchGoogle() {
		 driver.get("https://www.google.com/");
	
	 }
	 
 
@AfterClass
	public void tearDown() {
		 if(driver!=null) {
			 driver.quit();
		 }
	 }
	 
	 
}
