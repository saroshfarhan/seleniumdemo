package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class abstractPage {
    abstractPage(){
        System.setProperty("webdriver.fire.driver", "/Users/saroshfarhan/Downloads/geckodriver");
    }

    WebDriver driver = new FirefoxDriver();
    
    public void loadUrl(String url){
        driver.get(url);
    }

    public void enterInputText(By searchBar, String text){
        ((WebElement) searchBar).sendKeys(text);
    }

    public void clickButton(By button){
        ((WebElement) button).click();
    }
}
