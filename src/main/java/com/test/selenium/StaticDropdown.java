 package com.test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
        //dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        
        Select dropdown =  new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText() );
        
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        List<WebElement> options = dropdown.getOptions();   
        System.out.println(options.size());
	}

}
