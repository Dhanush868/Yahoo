package com.yahoo;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooTest {

	private static WebDriver driver = null;
	@BeforeClass
	public void configBeforeClass() {

	}
	@BeforeMethod
	public void cofigBeforeTest() throws Throwable{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/account/create?.intl=us&specId=yidregsimplified&done=https%3A%2F%2Fwww.yahoo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	@Test
	public void YH_001() throws Throwable {
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Dhanunjaya");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("y");
		driver.findElement(By.id("usernamereg-userId")).sendKeys("dhanu20018686");
		driver.findElement(By.id("usernamereg-password")).sendKeys("Yahoo@123");
		driver.findElement(By.id("usernamereg-birthYear")).sendKeys("2001");
		driver.findElement(By.id("reg-submit-button")).submit();
		driver.findElement(By.id("usernamereg-phone")).sendKeys("9876500970");
		driver.findElement(By.id("reg-submit-button")).submit();
		System.out.println(driver.getTitle());
	}
    @Test
	public void YH_002() throws Throwable {
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Dhanunjaya");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("y");
		driver.findElement(By.id("usernamereg-userId")).sendKeys("dhanu20018686");
		driver.findElement(By.id("usernamereg-password")).sendKeys("Yahoo@123");
		driver.findElement(By.id("usernamereg-birthYear")).sendKeys("2001");
		driver.findElement(By.id("reg-submit-button")).submit();
		driver.findElement(By.id("usernamereg-phone")).sendKeys("987650097057");
		driver.findElement(By.id("reg-error-phone")).getText().equals("That doesn’t look right, please re-enter your phone number.");
	}
    @Test
    public void YH_003() throws Throwable {
    	driver.findElement(By.linkText("Terms")).click();
    	Thread.sleep(10000);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        driver.getTitle().equals("Yahoo Terms of Service | Yahoo");
    }
    
	@AfterMethod
	public void configAfterClass() {
		driver.manage().window().minimize();
		driver.quit();
	}
	@AfterClass
	public void cofigAftereTest(){
	}
}
