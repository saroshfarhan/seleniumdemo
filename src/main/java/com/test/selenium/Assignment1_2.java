package com.test.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment1_2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        List<WebElement> checkboxes  = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label"));
        
        System.out.println("Number of checkboxes on the page are: "+ checkboxes.size());
        
        driver.close();

	}

}
