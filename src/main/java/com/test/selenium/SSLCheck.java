package com.test.selenium;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {


		FirefoxOptions options = new FirefoxOptions();

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		//available for chrome
		//options.setExperimentalOption("prefs", prefs);
	

// FirefoxOptions options1 = new FirefoxOptions();

// options1.setAcceptInsecureCerts(true);

// EdgeOptions options2 = new EdgeOptions();

		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.gecko.driver", "/Users/saroshfarhan/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver(options);

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

}
