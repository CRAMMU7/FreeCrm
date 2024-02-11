package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PropertiesPage;
import com.crm.qa.pages.PropertyDetailsPage;

public class PropertiesDetailsPageTest extends TestBase {

	PropertyDetailsPage propertydetailspage;
	PropertiesPage propertiespage;
	LoginPage loginpage;

	public PropertiesDetailsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws NumberFormatException, InterruptedException {
		TestBase.initialization();
		 propertydetailspage=new PropertyDetailsPage() ;
		loginpage=new LoginPage();
		propertiespage=new PropertiesPage();
        propertiespage=	loginpage.enterLocation(prop.getProperty("location"));
		propertydetailspage=propertiespage.getPropertyByPosition(Integer.parseInt(prop.getProperty("position")));

	}

	@Test
	public void getAgentDetailsTest()
	{
		propertydetailspage.getAgentDetails();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
