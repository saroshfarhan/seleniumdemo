package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();

        //correct password : rahulshettyacademy

        driver.get("https://rahulshettyacademy.com/locatorspractice");
        driver.findElement(By.id("inputUsername")).sendKeys("Sarosh");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshtyacademy");
        driver.findElement(By.className("signInBtn")).click();
        
        //wating explicitly for the elemnt to sjow up on UI
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));

         //Adding implicit wait
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Finding the error tesxt via className, uncomment to see in action
        //String errorMessage = driver.findElement(By.className("error")).getText();

        //Finding the error text by writing its cssSelector, comment to see classname above in action
        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println("####################################");
        System.out.println(errorMessage);
        System.out.println("####################################");

        driver.close();
        
    }
}
