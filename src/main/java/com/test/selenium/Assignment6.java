package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        
        //getting option2 text and then clicking it
        String option = driver.findElement(By.xpath("//label[@for='benz']")).getText();
        driver.findElement(By.id("checkBoxOption2")).click();
        
        //selecting option2 from static dropdown
        WebElement staticDrpDown = driver.findElement(By.id("dropdown-class-example"));
        Select dropDwn = new Select(staticDrpDown);
        dropDwn.selectByVisibleText(option);
        
        //sending option2 to the alertbox text and checking if text present in alertbox or not
        driver.findElement(By.id("name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();
        
        //switching to alert and getting text
        String textCheck = driver.switchTo().alert().getText();
        if(textCheck.contains(option)) {
        	System.out.println("Text contains " + option);
        }
        else {
        	System.err.println("Text doesn't contain "+option);
        }
        
        //accepting the alert
        driver.switchTo().alert().accept();
        
        driver.close();

	}

}
