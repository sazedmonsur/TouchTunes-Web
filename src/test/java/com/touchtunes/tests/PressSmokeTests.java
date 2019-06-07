package com.touchtunes.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.touchtunes.pages.PressPage;

public class PressSmokeTests {
	
	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver =  new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://www.touchtunes.com/about/press/");
	}
	
	//Task 2- Get all the links contains “touchtunes” and write to a file
	
	@Test(priority=0)
	public void GetAllLinksContainsTouchTunesAndWriteToFile () throws IOException {
	PressPage pp = new PressPage(driver);
	pp.WriteAllLinksContainsTouchTunestoFile();
	assertEquals(driver.getTitle(), "TouchTunes | Press");
	}
	
	//Task 3- Read all the links from file and check for broken links
	
	@Test(priority=1)
	public void VerifyPressLinksAndPrintBrokenLinks () throws IOException {
	PressPage pp = new PressPage(driver);
	pp.FindBrokenLinksFromFile();
	assertEquals(driver.getTitle(), "TouchTunes | Press");
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
		
	}
}
