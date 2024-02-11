package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AgentsPage extends TestBase {

	@FindBy(xpath="//div[@id=\"content\"]//descendant::h1/a")
	public WebElement AgentTitle;

	public AgentsPage() {
		PageFactory.initElements(driver,this);
	}

	public  String  verifyAgent() {

		String AgentTitleName=AgentTitle.getText();
		return AgentTitleName;

	}

}
