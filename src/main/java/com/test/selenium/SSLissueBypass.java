package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLissueBypass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");
		
		FirefoxOptions option = new FirefoxOptions();
		option.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(option);
        
        driver.get("https://expired.badssl.com/");
        
        System.out.println(driver.getTitle());
        
        driver.close();
        

	}

}
