package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory or ObjectRepository
	
	@FindBy(xpath="//a[@data-testid='zoopla-logo1']")
	public WebElement zooplaLogo;
	
	@FindBy(xpath="//input[contains(@id,'input')]")
	public WebElement Location;
	
	@FindBy(xpath="//div[(text()='Search')]")
	public WebElement Search;
	
	//Initializing the Pageobjects
	public LoginPage(){
	//PageFactory class . initElement method is used to initialise all  the objects of 'this' class
	PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return zooplaLogo.isDisplayed();
	}
	
	public PropertiesPage  enterLocation(String location)  {
		
		Location.sendKeys(location);
		Search.click();
        return new PropertiesPage();
}
	
	
	
	
	}

