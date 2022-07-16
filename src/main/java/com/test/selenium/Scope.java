package com.test.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        System.out.println(links.size());
        
//        for(int i = 0; i < links.size(); i++) {
//        	System.out.println(links.get(i).getAttribute("href"));
//        }
        
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        
        
        //Getting count of links in first column of footer
        
        WebElement columnDriver  = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        
        System.out.println(columnDriver.findElements(By.tagName("a")).size());
        
        
        //click on each link and check if pages are opening
        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
        	
        	String clickonLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
        	
        	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
        	Thread.sleep(5000);
        }
        
         Set<String>  windows = driver.getWindowHandles();
        
	     //to iterate in the set collection we created above we are using Iterator
	     Iterator<String> it = windows.iterator();
	     
	     while(it.hasNext()) {
	    	 String childId = it.next();
	    	 System.out.println(driver.switchTo().window(childId).getTitle());
	     }
	              
        driver.close();

	}

}
