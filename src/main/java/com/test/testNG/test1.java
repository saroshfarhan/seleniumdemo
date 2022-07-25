package com.test.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	@Test
	public void passingTest() {
		System.out.println("First TestNG test");
		Assert.assertTrue(true);
	}

}
