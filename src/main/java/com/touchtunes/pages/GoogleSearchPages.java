package com.touchtunes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPages {
	WebDriver driver;

	By searchbox = By.name("q");
	By submitButton = By.name("btnK");
	
	public GoogleSearchPages(WebDriver driver) {
		this.driver = driver;
	}	
	
	public void SearchText(String stext) {
	
		driver.findElement(searchbox).sendKeys(stext);
	}
	public void clickonSubmitButton() {
		
		driver.findElement(submitButton).click();
	}
	
	public void GoogleSearch(String stext) {
		SearchText(stext);
		clickonSubmitButton();
	}
	
}
