package com.testingshatra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testingshatra.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@src='https://ijmeet.com/images/LOGO-F@2x.png']")
	private  WebElement Logo;
	
	@FindBy(xpath="//a[@href='https://ijmeet.com/app']")
	private  WebElement JoinMeeting ;
	
	@FindBy(xpath="//a[@href='https://ijmeet.com/host_meeting']")
	private  WebElement HostMeeting ;
	
	@FindBy(xpath="//a[@href='https://ijmeet.com/contact']")
	private  WebElement  Contactsales  ;
	
	@FindBy(xpath="//a[@href='https://ijmeet.com/login']")
	private  WebElement SiggIn  ;
	
	@FindBy(xpath="//a[@href='https://ijmeet.com/register']")
	private  WebElement SiggUp  ;
	
	//@FindBy(xpath="//img[@src='https://ijmeet.com/images/profile_img/flag-view.png']")
	//private  WebElement  عربى ;
	
	@FindBy(xpath="//span[@class=\"language-trance-arabic\"]")
	 private  WebElement  imgarabic ;

}
