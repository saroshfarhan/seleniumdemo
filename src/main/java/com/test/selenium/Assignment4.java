package com.test.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://the-internet.herokuapp.com/windows");
        
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        
        Set<String>  windows = driver.getWindowHandles();
        
        Iterator<String> it = windows.iterator();
        
        String parentId = it.next();
        String childId = it.next();
        
        driver.switchTo().window(childId);
        
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        
        driver.switchTo().window(parentId);
        
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        
        driver.quit();
        

	}

}
