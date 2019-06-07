package com.touchtunes.tests;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.touchtunes.pages.GoogleSearchPages;

public class VerifyGoogleSearch {
	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
	driver =  new ChromeDriver();	
	driver.manage().window().maximize();
	driver.get("https://google.com");
	
	}
	
	//Task 1- Search touchtunes on Google and Verify correct result is returned
	
	@Test
	public void verifyValidGoogleSearchResult() {
		String searchString ="TouchTunes";
		GoogleSearchPages GSP = new GoogleSearchPages(driver);
		GSP.GoogleSearch(searchString);
		driver.getPageSource().contains(searchString);
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}

}
