package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Assignment1_1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        driver.findElement(By.id("checkBoxOption1")).click();
        
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        
        driver.findElement(By.id("checkBoxOption1")).click();
        
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        
        driver.close();
        
        
	}

}
