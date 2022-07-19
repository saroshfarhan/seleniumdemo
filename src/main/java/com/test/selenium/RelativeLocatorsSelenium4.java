package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsSelenium4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Using above()
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		String labelText = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

		System.out.println(labelText);
		
		
		//Using below()
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		
		
		//Using toLeftOf()
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		
		//Using toRightOf()
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		

		driver.close();
	}

}
