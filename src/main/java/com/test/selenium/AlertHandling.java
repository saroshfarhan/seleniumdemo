package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class AlertHandling {

	public static void main(String[] args) {

		String text = "Sarosh";

		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains("Hello Sarosh")) {
			System.out.println(alertText);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();

		driver.close();

	}

}
