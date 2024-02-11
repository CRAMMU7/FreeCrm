package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PropertyDetailsPage extends TestBase {

	public String AgentNameText;
	
	@FindBy(xpath="//h2[@id='agent-details-heading']//parent:: section/div/div/div/p")
	public WebElement AgentName;
	
	
	@FindBy(xpath="//h2[@id='agent-details-heading']//parent:: section/div/div[1]/a/img")
	public WebElement LogoText;
	
	@FindBy(xpath="//h2[@id='agent-details-heading']//parent:: section/div/div[2]/div[1]/div/button/div/div[2]")
	public WebElement CallImg;
	
	@FindBy(xpath="//a[contains(@href,'tel:')]")
	public WebElement phoneNum;
	
	@FindBy(xpath="//a[contains(text(),'View agent properties')]")
	public WebElement Viewagent;
	
	@FindBy(xpath="//a[contains(@data-testid,'agent-email')]")
	public WebElement AgentEmail;
	
	public PropertyDetailsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void getAgentDetails() {
		System.out.println("AgentName-"+AgentName.getText());
		System.out.println(LogoText.getAttribute("alt"));
		CallImg.click();
		System.out.println(phoneNum.getAttribute("href").replaceAll("tel:", ""));
		

	}
	
	public AgentsPage getAgentsPage() {
		AgentNameText=AgentName.getText();
		Viewagent.click();
		return new AgentsPage();
	
	}

	public EmailPage getEmailPage() {
		
		AgentEmail.click();
		return new EmailPage();
	
	}
	
}


