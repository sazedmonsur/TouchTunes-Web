/**
 * 
 */
package com.touchtunes.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sazed
 *
 */
public class PressPage {

	WebDriver driver;
	
	public PressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Linktext = By.tagName("a");
	
	
	public void WriteAllLinksContainsTouchTunestoFile() throws IOException {
		
		FileWriter w = new FileWriter("C:\\Log\\SearchResults.txt");
		List<WebElement> AllLinks = driver.findElements(Linktext);
		for(WebElement link:AllLinks) {
			if (link.getText().contains("TouchTunes")) {
				String getLink=link.getAttribute("href");
				System.out.println(getLink);
				 BufferedWriter out = new BufferedWriter(w);
					out.write(getLink+"\n");
					out.flush();
				
			}	
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void FindBrokenLinksFromFile() throws IOException {
		
		ArrayList<String> Linkslist = new ArrayList<String>();
		
		Scanner s = new Scanner(new File("C:\\Log\\SearchResults.txt"));
		
		while (s.hasNext()){
		    Linkslist.add(s.next());
		}
		s.close();
		
		for(int i=0;i<Linkslist.size();i++)
		{
			String url= Linkslist.get(i);
			BrokenLinks(url);
			
		}
	}
	
	public void BrokenLinks(String LinkURL) throws IOException {
		try {
					  
			URL url = new URL(LinkURL);
			 HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	          httpURLConnect.setConnectTimeout(3000); 
	          httpURLConnect.connect();
	          if(httpURLConnect.getResponseCode()==200)
	           {
	               //System.out.println(LinkURL+" - "+ httpURLConnect.getResponseMessage());
	            }
	          else{
	               System.out.println("Broken Link - "+LinkURL+ " - " + httpURLConnect.getResponseMessage());
	            }
				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}
	
	
}
