package com.test.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class firstTest{
    firstTest(){
        System.setProperty("webdriver.firefox.driver", "/Users/saroshfarhan/Downloads/geckodriver");
    }
    

    WebDriver driver = new FirefoxDriver();

    @Test(priority = 1, groups = "Functional")
    public void test() throws InterruptedException{
        driver.get("https://www.google.com");
        wait(2000);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("happy feet");
        wait(2000);
        WebElement searchBtn =  driver.findElement(By.name("btnK"));
        searchBtn.click();
        wait(2000);
        System.out.println(driver.getTitle());
        driver.close();
    }
    


}
