package com.test.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

        WebDriver driver = new FirefoxDriver();
        
        driver.manage().window().maximize();
        
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        
        login_to_application(driver);
        
        add_products_to_cart_and_checkout(driver);
        
        driver.close();

	}
	
	public static void login_to_application(WebDriver driver) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");;
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[normalize-space()='User']")).click();
		
		//Explicit wait for popup and click on Okay.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select.form-control")));
		Thread.sleep(3000);
		WebElement dropDwnfield = driver.findElement(By.cssSelector("select.form-control"));
		Select dropDwn = new Select(dropDwnfield);
		dropDwn.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card-footer']")));
		
		System.out.println("Logged in");
	}
	
	public static void add_products_to_cart_and_checkout(WebDriver driver) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-info")));
		List<WebElement> addBtn =  driver.findElements(By.cssSelector("button.btn.btn-info"));
		
		for(int i=0; i<addBtn.size(); i++) {
			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Checkout']")));
		
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
//		driver.findElement(By.id("country")).sendKeys("Ind");
//		
//		List<WebElement> options = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));
//		
//		for(WebElement option: options) {
//			if(option.getText().equalsIgnoreCase("India")) {
//				//wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(option));
//				Thread.sleep(2000);
//				option.click();
//			}
//		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.checkbox.checkbox-primary")));
		driver.findElement(By.cssSelector("div.checkbox.checkbox-primary")).click();
		
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-lg']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	}

}
