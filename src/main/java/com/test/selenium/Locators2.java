package com.test.selenium;

import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        
        //implicit wait - 2 seconds time out
    	String name = "rahul";
        
        System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        String password = getPassword(driver);
        
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
        
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        
        driver.close();
    }

	private static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
	    Thread.sleep(1000);//
	    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passText = driver.findElement(By.cssSelector("form p")).getText();
        String password = passText.split("'")[1].split("'")[0];
        
		return password;
	}
}
