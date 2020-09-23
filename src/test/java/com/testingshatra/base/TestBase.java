package com.testingshatra.base;

import org.testng.annotations.BeforeSuite;

import com.testingshatra.keywords.FEKeywords;

public class TestBase {
	@BeforeSuite
	public void openBrowser() {
		FEKeywords.openBrowser("Chrome");

	}

}
