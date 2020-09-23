package com.testingshatra.keywords;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingshatra.utils.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * it will launch the specified browser
 *@param browserName has to e one of:
 *<ul>
 *<li>Chrome</li>
 *<li>Firefox</li>
 *<li>Safari</li>
 *<li>HeadLess</li>
 *<li>IE</li>
 *</ul>
 */

public class FEKeywords {
	
	public static WebDriver driver;
   
	static Logger log=Logger.getLogger(FEKeywords.class);
	/**
	 * Opens Specified Web Browser
	 * @param browserName.browser name  should only include Chrome,Firefox,IE,Htmlunit,safari.
	 * no browserName apart form mentioned is allowed.  
	 */
	
	public static void openBrowser(String browserName)
	{
		switch (browserName) {
		case "Chrome":
			System.out.println("Opening Chrome Browser");
			WebDriverManager.chromedriver().setup();
			log.info("Launching"+browserName+"browser");
			Constant.driver=new ChromeDriver();
			
			 break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			log.info("Launching"+browserName+"browser");
			Constant.driver=new FirefoxDriver();
			 break;
		case "Safari":
			log.info("Launching"+browserName+"browser");
			Constant.driver=new SafariDriver();
			 break;
		/*case "Headless":
			log.info("Launching"+browserName+"browser");
			Constant.driver=new HtmlUnitDriver();
			 break;*/
		default:log.error("unable to launch.invalid nbrowser name:"+browserName);
			break;
		}
	}
	/**
	 * It opens the specified url in web browser recently open by driver instance
	 * @param url{@code String}  url to open
	 * @return void
	 */
	public static void launchUrl(String url)
	{
		System.out.println(url+"is loading......");
		Constant.driver.get(url);
	}
	 private static  WebElement getWebelement(String locatorType,String locatorValue) {
		 WebElement e;
		 switch (locatorType) {
	     case "XPATH":
	    	 return Constant.driver.findElement(By.xpath(locatorValue));
	    		
	     case "CSS":
	    	 return Constant.driver.findElement(By.cssSelector(locatorValue));
	    	 
	     case "ID":
	    	 return Constant.driver.findElement(By.id(locatorValue));
	    	 
	     case "NAME":
	    	 return Constant.driver.findElement(By.name(locatorValue));
	    	 
	     case "LINKTEXT":
	    	 return Constant.driver.findElement(By.linkText(locatorValue));
	    	 
	     case "PARTIAL_LINK_TEXT":
	    	 return Constant.driver.findElement(By.partialLinkText(locatorValue));

	     case "CLASS_NAME":
	    	 return Constant.driver.findElement(By.className(locatorValue));
	     default:
	 		System.err.println("Invalid Locator Type:"+locatorType+".Excepted:XPATH,CSS,NAME,ID,CLASS_NAME,CLASS_NAME,LINKTEXT");
	 		return null;
	 		 
		}
}
	public static boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public static boolean isElementDisplayed(String locatorType,String locatorValue)
	{
   
		return getWebelement(locatorType, locatorValue).isDisplayed();
	}

	public static void clickOnElement(String locatorType,String locatorValue) {
		getWebelement(locatorType, locatorValue).click();

	}
	public static void enterText(String locatorType,String locatorValue,String textToEnter) {
		getWebelement(locatorType, locatorValue).sendKeys(textToEnter);

	}
	public static WebElement mouseHover(String locatorType,String locatorValue)
	{
		WebElement element=getWebelement(locatorType,locatorValue);
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		return element;

	}
	public static String waitForElementToVisible(String locatorType,String locatorValue)
	{
		WebElement element=getWebelement(locatorType,locatorValue);
		WebDriverWait wait=new WebDriverWait(driver,10);
		Constant.text=wait.until(ExpectedConditions.visibilityOf(element)).getText();
		return Constant.text;
	}
	
	/*public static int displayOfElement(String locatorType,String locatorValue)
	{
		
	List<WebElement> elements=getWebelements(locatorType,locatorValue);
	for(WebElement ele:elements)
	{
		ele.getSize();
		Constant.count++;
	}
		return Constant.count;
	}*/
	
	public static String  getWindowHandleOfPage()
	{
		Constant.text=driver.getWindowHandle();
		return Constant.text;
		
	}
	
	
	public static String  getTitleeOfPage()
	{
		Constant.text=driver.getTitle();
		return Constant.text;
		
	}
	public static void  switchToMainWindow()
	{
		driver.switchTo().window(Constant.text);
	}
	
	public static void  nevigateBack()
	{
		driver.navigate().back();
	}
	
	public static void  nevigateForward()
	{
		driver.navigate().forward();
	}
	public static String  getCurrentUrlOfPage()
	{
		Constant.text=driver.getCurrentUrl();
		return Constant.text;
	}
	public static String getText(String locatorType,String locatorValue)
	{
		WebElement element=getWebelement(locatorType,locatorValue);
		return element.getText();
		
	}
	
	public static void maximizeBrowser() {
		Constant.driver.manage().window().maximize();

	}
	public static void closeBrowser() {
		Constant.driver.close();

	}
	public static void CloseAllBrowser() {
		Constant.driver.quit();
}
}