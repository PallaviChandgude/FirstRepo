package com.testingshatra.functionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshatra.keywords.FEKeywords;
import com.testingshatra.keywords.WaitFor;
import com.testingshatra.utils.Constant;

import net.sourceforge.htmlunit.corejs.javascript.debug.Debugger;

public class HomePageTests {
	//@Test(description="Refer test case number TC_001")
	
    @Test
	public void verifyIfLogoPresent()
	{
		
		FEKeywords.openBrowser("Chrome");
		FEKeywords.launchUrl(Constant.baseurl);
		
        Assert.assertTrue(FEKeywords.isElementDisplayed("XPATH", "//img[@src=\"https://ijmeet.com/images/LOGO-F@2x.png\"]"));
		
		/*WebElement logo=FEKeywords.driver.findElement(By.xpath("//img[@src=\"https://ijmeet.com/images/LOGO-F@2x.png\"]"));
		Assert.assertTrue(logo.isDisplayed(),"Logo is not present");*/
		
	}
		
	@Test
	public void veryFyTitle()
	{
			String title=FEKeywords.getTitleeOfPage();
			 Assert.assertEquals(title, "IJmeet", "invalid tiltle");
	}
	
	@Test
	public void verifyPresenceOfAllMenuItems() {
		FEKeywords.openBrowser("Chrome");
		FEKeywords.launchUrl(Constant.baseurl);
		//WaitFor.minTime();
	}
	@Test
	//Run | Debug
	public void verifyRedirectigOnJoinMeeting() {
		FEKeywords.openBrowser("Chrome");
		FEKeywords.launchUrl(Constant.baseurl);

	}

}

