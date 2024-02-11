package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AgentsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PropertiesPage;
import com.crm.qa.pages.PropertyDetailsPage;

public class AgentsPageTest extends TestBase{
	AgentsPage agentsPage;
	AgentsPageTest AgentsPageTest;
	PropertyDetailsPage propertydetailspage;
	PropertiesPage propertiespage;
	LoginPage loginpage;
	public AgentsPageTest() {
		super();
	}

	public void setUp()  {
		TestBase.initialization();
		AgentsPageTest=new AgentsPageTest();
		agentsPage=new AgentsPage();
		propertydetailspage=new PropertyDetailsPage();
	
		propertiespage=	loginpage.enterLocation(prop.getProperty("location"));
		propertydetailspage=propertiespage.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));
		propertydetailspage.getAgentsPage();
	}

	public void verifyAgentTest() {
		Assert.assertTrue(agentsPage.verifyAgent().contains(propertydetailspage.AgentNameText));
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
