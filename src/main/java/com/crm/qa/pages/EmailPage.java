package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class EmailPage extends TestBase{
	
	@FindBy(xpath="//button[@id='interest']")
	public WebElement interest;
	
	@FindBy(xpath="//input[@id='name']")
	@CacheLookup
	public WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='phone']")
	public WebElement phone;
	
	@FindBy(xpath="//input[@id='postcode']")
	public WebElement postcode;
	
	@FindBy(xpath="//div[contains(text(),'Please select')]")
	public WebElement selectsituation;
	
	@FindBy(xpath="//li[contains(@id,'item-3')]")
	public WebElement item3;
	
	@FindBy(xpath="//span[contains(@id,'recaptcha-anchor')]")
	public WebElement recaptcha;
	
	@FindBy(xpath="//div[contains(text(),'Send enquiry')]")
	public WebElement Sendenquiry;
	
	public EmailPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void sendEnquiryToAgent(String nme,String mail,String phon,String post) {
		interest.click();
		name.sendKeys(nme);
		email.sendKeys(mail);
		phone.sendKeys(phon);
		postcode.sendKeys(post);
		
		selectsituation.click();
		item3.click();
		recaptcha.click();
		Sendenquiry.click();
		
	}

}
