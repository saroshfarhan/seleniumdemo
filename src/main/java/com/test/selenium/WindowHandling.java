package com.test.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        
        driver.findElement(By.cssSelector(".blinkingText")).click();
        
        //doing so that we get the ids of the windows that are open
        Set<String>  windows = driver.getWindowHandles();
        
        //to iterate in the set collection we created above we are using Iterator
        Iterator<String> it = windows.iterator();
        
        String parentId = it.next();
        
        String childId = it.next();
        
        driver.switchTo().window(childId);
        
        String email = driver.findElement(By.xpath("//p[@class='im-para red']/strong")).getText();
        
        driver.switchTo().window(parentId);
        
        driver.findElement(By.id("username")).sendKeys(email);
        
        driver.findElement(By.id("password")).sendKeys("password");
        
        

	}

}
