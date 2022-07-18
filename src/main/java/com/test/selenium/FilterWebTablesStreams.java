package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterWebTablesStreams {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

		// 1 results

		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).

				collect(Collectors.toList());

		// 1 result

		Assert.assertEquals(veggies.size(), filteredList.size());

	}

}
