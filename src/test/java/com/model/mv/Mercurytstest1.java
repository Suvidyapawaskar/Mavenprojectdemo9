package com.model.mv;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercurytstest1 {
	 public WebDriver driver;
	  
	  @Test(priority=1)
	  public void loginwithValidds()
	  {
		  System.out.println("In loginwithValidds under Test1");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  boolean exp_flag =true;
		  Assert.assertEquals(act_flag, exp_flag);
		  driver.findElement(By.linkText("SIGN-OFF")).click();	  
		  System.out.println("Signoff link is clicked by user");
	  }
	  
	  @Test(priority=2)
	  public void loginwithValidds1() {
		  
		  System.out.println("In loginwithValidds1 under Test2");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  boolean exp_flag1 =true;
		  Assert.assertEquals(act_flag1, exp_flag1);
		  driver.findElement(By.linkText("SIGN-OFF")).click();	  
		  
	  }
	  
	  @Test(priority=3)
	  public void loginwithInvalidds() {
		  
		  System.out.println("In loginwithInvalidds under Test3");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  boolean act_flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		  boolean exp_flag2 =true;
		  Assert.assertEquals(act_flag2, exp_flag2);	  
		  
	  }
	  
	  
	  @BeforeMethod
	  public void getAllcookies()
	  {
		  System.out.println("In getAllcookies under BeforeMethod");
		  Set<Cookie> cookies=driver.manage().getCookies();
		  for (Cookie cookie:cookies)
		  {
			  System.out.println("The name of cookie is:"+cookie.getName());
		  }
	  }

	  @AfterMethod
	  public void captureScrrenshot(ITestResult result) throws IOException 
	  {
		  if(result.FAILURE==result.getStatus())
		  {
			System.out.println("The test failed is:"+result.getName());
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("F:\\Suvidya_data\\Java_Selenium\\Mavenprojectdemo9\\src\\test\\resources\\Screenshots\\invalidlogin.jpeg"));
			
		  }
		  
	  }

	  @BeforeClass
	  public void maximixeBrowser() {
		  System.out.println("In maximixeBrowser under BeforeClass");
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void deconnectionClosed() 
	  
	  {
		  System.out.println("In deconnectionClosed method under AfterClass");
	  }

	  @BeforeTest
	  public void enterApplicationurl() {
		  
		  System.out.println("In enterApplicationurl method under BeforeTest");
		  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		  System.out.println("Application url is entered successfully");
	  }

	  @AfterTest
	  public void deleteAllcookies()
	  
	  {
		  System.out.println("In deleteAllcookies method under AfterTest");
		  driver.manage().deleteAllCookies();
	  }

	  @BeforeSuite
	  public void openBrowser() 
	  
	  {
		  System.out.println("In openBrowser method under BeforeSuite");
		  System.setProperty("webdriver.chrome.driver","G:\\Selenium Setup\\setup1\\16122018\\chromedriver_win32 (14)\\chromedriver.exe");
		  driver= new ChromeDriver();
		  
		  
	  }

	  @AfterSuite
	  public void closeBrowser() 
	  {
		  System.out.println("In closeBrowser under AfterSuite");
		  driver.close();
	  }

}
