package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        //Defining all the webelements first to consume it later
        By name = By.name("name");
        
        By email = By.name("email");
        
        By password = By.id("exampleInputPassword1");
        
        By checkbox = By.id("exampleCheck1");
        
        WebElement genderDrpDwn = driver.findElement(By.id("exampleFormControlSelect1"));
        Select gender =  new Select(genderDrpDwn);
        
        By statusRadio1 = By.id("inlineRadio1");
        
        By dob = By.name("bday");
        
        By submitBtn = By.xpath("//input[@value='Submit']");
        
        By successMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        
        
        //Starting actual flow of the testcase
        driver.findElement(name).sendKeys("Sarosh Farhan");
        
        driver.findElement(email).sendKeys("sfarhan@gmail.com");
        
        driver.findElement(password).sendKeys("abc@12334");
        
        driver.findElement(checkbox).click();
        
        gender.selectByVisibleText("Male");
        
        driver.findElement(statusRadio1).click();
        
        driver.findElement(dob).sendKeys("24/06/1993");
        
        driver.findElement(submitBtn).click();
        
        System.out.println(driver.findElement(successMsg).getText());
        
        driver.close();

	}

}
